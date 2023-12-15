package com.example.aula7exercicio5

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // URL da imagem que você deseja exibir
        val imageUrl =
            "https://i.pinimg.com/736x/7b/18/08/7b1808f4ed662bf836fa11a2a766e535.jpg"

        val imageView = findViewById<ImageView>(R.id.imageView)

        // Use a biblioteca Glide para carregar a imagem na ImageView
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)

        // Adiciona o efeito de hover à ImageView
        imageView.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Ao tocar na imagem, aumenta a escala
                    view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Quando o toque é liberado ou cancelado, retorna à escala original
                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start()
                }
            }
            true
        }
    }
}
