package com.example.musicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            isPlaying = !isPlaying
            binding.playButton.text = if (isPlaying) "Pause" else "Play"
      miniPlayer = findViewById(R.id.miniPlayer)
songTitleMini = findViewById(R.id.songTitleMini)
artistMini = findViewById(R.id.artistMini)
playPauseMini = findViewById(R.id.btnPlayPauseMini)
        
        }
    }

}


private lateinit var seekBar: SeekBar
private var updateHandler = Handler(Looper.getMainLooper())

private val updateSeekBar = object : Runnable {
    override fun run() {
        mediaPlayer?.let {
            seekBar.progress = it.currentPosition
            updateHandler.postDelayed(this, 1000)
        }
    }
}


seekBar.max = mediaPlayer.duration
updateHandler.post(updateSeekBar)


var isShuffle = false
var isRepeat = false

shuffleButton.setOnClickListener {
    isShuffle = !isShuffle
    shuffleButton.text = if (isShuffle) "Shuffle On" else "Shuffle Off"
}

repeatButton.setOnClickListener {
    isRepeat = !isRepeat
    repeatButton.text = if (isRepeat) "Repeat On" else "Repeat Off"
}


private lateinit var miniPlayer: LinearLayout
private lateinit var songTitleMini: TextView
private lateinit var artistMini: TextView
private lateinit var playPauseMini: ImageButton


fun updateMiniPlayer(songTitle: String, artist: String) {
    songTitleMini.text = songTitle
    artistMini.text = artist
    playPauseMini.setImageResource(R.drawable.ic_pause)
}

playPauseMini.setImageResource(R.drawable.ic_play_arrow)

playPauseMini.setOnClickListener {
    if (mediaPlayer?.isPlaying == true) {
        mediaPlayer?.pause()
        playPauseMini.setImageResource(R.drawable.ic_play_arrow)
    } else {
        mediaPlayer?.start()
        playPauseMini.setImageResource(R.drawable.ic_pause)
    }
}
