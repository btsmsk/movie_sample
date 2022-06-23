package com.bsimsek.moviekmmsample.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bsimsek.moviekmmsample.android.R
import com.bsimsek.moviekmmsample.android.ui.theme.Shapes
import com.bsimsek.moviekmmsample.android.ui.theme.keyLine1
import com.bsimsek.moviekmmsample.android.ui.theme.keyLine2

@Composable
fun RateChip(rate: String, modifier: Modifier) {
    Card(
        elevation = 4.dp,
        modifier = modifier,
        shape = Shapes.large,
        backgroundColor = MaterialTheme.colors.onSecondary
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(vertical = keyLine1, horizontal = keyLine2)
        ) {
            val (iconRef, rateTextRef) = createRefs()
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = "Rate star",
                modifier = Modifier
                    .size(16.dp)
                    .constrainAs(iconRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    },
                tint = Color.Unspecified
            )
            Text(
                text = rate,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.constrainAs(rateTextRef) {
                    top.linkTo(parent.top)
                    start.linkTo(iconRef.end, margin = keyLine1)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
        }
    }
}