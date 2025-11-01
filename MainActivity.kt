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


