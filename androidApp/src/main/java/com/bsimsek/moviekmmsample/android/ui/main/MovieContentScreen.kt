package com.bsimsek.moviekmmsample.android.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.bsimsek.moviekmmsample.android.R
import com.bsimsek.moviekmmsample.android.ui.components.RateChip
import com.bsimsek.moviekmmsample.android.ui.theme.DarkTheme
import com.bsimsek.moviekmmsample.android.ui.theme.Shapes
import com.bsimsek.moviekmmsample.android.ui.theme.keyLine2
import com.bsimsek.moviekmmsample.android.ui.theme.keyLine3
import com.bsimsek.moviekmmsample.data.model.local.Movie
import com.bsimsek.moviekmmsample.data.model.remote.MovieResponse
import com.bsimsek.moviekmmsample.data.model.remote.asDomainMovieList

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieContentScreen(
    movieList: List<Movie>,
    onMovieClicked: (movieId: Long) -> Unit
) {
    Scaffold(
        Modifier.background(MaterialTheme.colors.background)
    ) {
        LazyColumn(contentPadding = PaddingValues(keyLine3)) {
            items(movieList) {
                Column {
                    Card(
                        elevation = 2.dp,
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .clickable { onMovieClicked(it.movieId) },
                        shape = Shapes.large
                    ) {
                        ConstraintLayout {
                            val (imageRef, titleRef, releaseDateRef, rateRef) = createRefs()
                            Image(
                                painter = if (it.posterPath.isEmpty()) painterResource(id = R.drawable.default_image) else rememberImagePainter(
                                    data = it.poster
                                ),
                                contentDescription = it.originalTitle,
                                modifier = Modifier
                                    .size(100.dp)
                                    .constrainAs(imageRef) {
                                        top.linkTo(parent.top)
                                        start.linkTo(parent.start)
                                    },
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                text = it.originalTitle,
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier.constrainAs(titleRef) {
                                    top.linkTo(parent.top, keyLine3)
                                    start.linkTo(imageRef.end, margin = keyLine2)
                                    end.linkTo(parent.end, margin = keyLine2)
                                    width = Dimension.fillToConstraints
                                })
                            Text(
                                text = "Release Date: ${it.releaseDate}",
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .constrainAs(releaseDateRef) {
                                        top.linkTo(titleRef.bottom)
                                        start.linkTo(titleRef.start)
                                        bottom.linkTo(parent.bottom, keyLine3)
                                        width = Dimension.fillToConstraints
                                    },
                                textAlign = TextAlign.Start,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 7
                            )
                            Spacer(modifier = Modifier.fillMaxWidth())
                            RateChip(
                                rate = it.average,
                                modifier = Modifier
                                    .background(Color.Transparent)
                                    .constrainAs(rateRef) {
                                        top.linkTo(releaseDateRef.top)
                                        bottom.linkTo(releaseDateRef.bottom)
                                        end.linkTo(parent.end, margin = keyLine2)
                                    },
                            )
                        }
                    }
                    if (movieList.last().movieId != it.movieId) Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
@Preview
fun MovieContentScreenPreview() = DarkTheme {
    MovieContentScreen(
        movieList = MovieResponse.mocked.movieList.asDomainMovieList(),
        onMovieClicked = { })
}