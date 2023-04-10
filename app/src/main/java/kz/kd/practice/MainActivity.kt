package kz.kd.practice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

private const val CHANNEL_ID = "1234"
const val EXTRA_NOTIFICATION_ID = "NOTIFICATION_ID"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShow: Button = findViewById(R.id.btn_show_notification)
        btnShow.setOnClickListener {
            showNotification()
        }

        val btnShow2: Button = findViewById(R.id.btn_show_notification_2)
        btnShow2.setOnClickListener {
            showNotificationWithActionButton()
        }

        val btnShow3: Button = findViewById(R.id.btn_show_notification_image)
        btnShow3.setOnClickListener {
            showNotificationWithImage()
        }

        val btnShow4: Button = findViewById(R.id.btn_show_notification_image_2)
        btnShow4.setOnClickListener {
            showNotificationWithImageSmall()
        }

        val btnShow5: Button = findViewById(R.id.btn_show_notification_long)
        btnShow5.setOnClickListener {
            showNotificationWithLongText()
        }

        val btnShow6: Button = findViewById(R.id.btn_show_notification_long_2)
        btnShow6.setOnClickListener {
            showNotificationWithLinedText()
        }

        createNotificationChannel()
    }

    private fun showNotification() {
        val intent = Intent(this, NotificationActivity::class.java)
//        val intent = Intent(this, NotificationActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or FLAG_IMMUTABLE
        )

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My notification")
            .setContentText("Hello There!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationID = Random.nextInt()
        NotificationManagerCompat.from(this).notify(notificationID, builder.build())
    }

    private fun showNotificationWithActionButton() {
        val notificationID = Random.nextInt()
        val customActionIntent = Intent(this, CustomActionBroadCastReceiver::class.java).apply {
            putExtra(EXTRA_NOTIFICATION_ID, notificationID)
        }

        val customActionPendingIntent: PendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            customActionIntent,
            PendingIntent.FLAG_ONE_SHOT or FLAG_IMMUTABLE
        )

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My notification")
            .setContentText("Hello There!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        builder.addAction(
            android.R.drawable.ic_dialog_info,
            "Custom Button",
            customActionPendingIntent
        )

        NotificationManagerCompat.from(this).notify(notificationID, builder.build())
    }

    private fun showNotificationWithImage() {
        val bitmapOfCat = BitmapFactory.decodeResource(resources, R.drawable.ic_poster)
        val builder: NotificationCompat.Builder = getCommonNotificationBuilder()
        builder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmapOfCat))

        NotificationManagerCompat.from(this).notify(Int.MIN_VALUE, builder.build())
    }

    private fun showNotificationWithImageSmall() {
        val bitmapOfCat = BitmapFactory.decodeResource(resources, R.drawable.ic_poster)
        val builder: NotificationCompat.Builder = getCommonNotificationBuilder()
        builder.setLargeIcon(bitmapOfCat)

        NotificationManagerCompat.from(this).notify(Int.MIN_VALUE, builder.build())
    }

    private fun showNotificationWithLongText() {
        val builder: NotificationCompat.Builder = getCommonNotificationBuilder()
        val longText =
            "Counting more than half a billion individuals and over 70 different breeds, cats are the world's most popular pets."
        builder.setStyle(NotificationCompat.BigTextStyle().bigText(longText))

        NotificationManagerCompat.from(this).notify(Int.MIN_VALUE, builder.build())
    }

    private fun showNotificationWithLinedText() {
        val builder: NotificationCompat.Builder = getCommonNotificationBuilder()

        builder.setStyle(
            NotificationCompat.InboxStyle()
                .addLine("The cat is one of the most popular pets.")
                .addLine("Currently there are around 600 million domestic cats in the world.")
                .addLine("Cats became domestic about 9500 years ago in the East. ")
                .addLine("People valued a lot cats' abilities to catch mice and rats.")
        )

        NotificationManagerCompat.from(this).notify(Int.MIN_VALUE, builder.build())
    }

    private fun createNotificationChannel() {
        val name = "Lesson 27 Channel"
        val descriptionText = "This is our first channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun getCommonNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My notification")
            .setContentText("Hello There!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
    }
}

class CustomActionBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "CustomActionBroadCastReceiver called", Toast.LENGTH_SHORT).show()
        val notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, 0)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(notificationId)
    }
}