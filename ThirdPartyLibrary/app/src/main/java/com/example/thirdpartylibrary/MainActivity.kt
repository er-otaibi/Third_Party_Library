package com.example.thirdpartylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var fab: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         button = findViewById(R.id.button)
         fab = findViewById(R.id.fab)
        showFabPrompt()
    }

    private fun showFabPrompt() {


            MaterialTapTargetPrompt.Builder(this)
                .setTarget(fab)
                .setPrimaryText("Click me!")
                .setSecondaryText("I'm a floating action button aka FAB.")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { _, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                        || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED
                    ) { showButtonPrompt() } }
                .show()

    }

    private fun showButtonPrompt() {
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(button)
            .setPrimaryText("Press me!")
            .setSecondaryText("I'm a nice and simple button.")
            .setBackButtonDismissEnabled(true)
            .setPromptBackground(RectanglePromptBackground())
            .setPromptFocal(RectanglePromptFocal())
            .show()
    }

}