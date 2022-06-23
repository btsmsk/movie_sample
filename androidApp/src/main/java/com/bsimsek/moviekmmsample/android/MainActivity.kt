package com.bsimsek.moviekmmsample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.bsimsek.moviekmmsample.android.ui.navigation.NavGraph
import com.bsimsek.moviekmmsample.android.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                NavGraph()
            }
        }
    }
}
