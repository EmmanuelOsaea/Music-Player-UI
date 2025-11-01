package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class NowPlayingActivity : AppCompatActivity() {

    private lateinit var albumArt: ImageView
    private lateinit var songTitle: TextView
    private lateinit var artistName: TextView
    private lateinit var playPauseBtn: ImageButton
    private lateinit var nextBtn: ImageButton
    private lateinit var prevBtn: ImageButton
    private lateinit var seekBar: SeekBar
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)

        albumArt = findViewById(R.id.albumArt)
        songTitle = findViewById(R.id.songTitle)
        artistName = findViewById(R.id.artistName)
        playPauseBtn = findViewById(R.id.playPauseBtn)
        nextBtn = findViewById(R.id.nextBtn)
        prevBtn = findViewById(R.id.prevBtn)
        seekBar = findViewById(R.id.seekBar)

        // Retrieve data passed from MainActivity
        val title = intent.getStringExtra("songTitle") ?: "Unknown Title"
        val artist = intent.getStringExtra("artist") ?: "Unknown Artist"

        songTitle.text = title
        artistName.text = artist

        // Play the song (you can extend this with actual playback)
        playPauseBtn.setOnClickListener {
            Toast.makeText(this, "Play/Pause clicked", Toast.LENGTH_SHORT).show()
        }

        nextBtn.setOnClickListener {
            Toast.makeText(this, "Next song", Toast.LENGTH_SHORT).show()
        }

        prevBtn.setOnClickListener {
            Toast.makeText(this, "Previous song", Toast.LENGTH_SHORT).show()
        }
    }
}
