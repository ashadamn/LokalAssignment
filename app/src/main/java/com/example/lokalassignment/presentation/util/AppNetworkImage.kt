package com.example.lokalassignment.presentation.util


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.rememberAsyncImagePainter


/**
 * The [AppNetworkImage] is a custom Composable function in Jetpack Compose, used to display
 * images asynchronously.
 *
 * @param modifier Modifier used to adjust the layout algorithm or draw decoration content.
 * @param model Either an [ImageRequest] or the [ImageRequest.data] value.
 * @param errorImage A [Painter] that is displayed while the image request fails.
 * @param contentDescription Text used by accessibility services to describe what this image
 *  represents.
 * @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be
 *  used.
 * @param colorFilter Optional colorFilter to apply for the Painter when it is rendered onscreen
 * @param alpha Optional opacity to be applied to the AsyncImagePainter when it is
 * rendered onscreen.
 */

//TODO Resource issue
@Composable
fun AppNetworkImage(
    modifier: Modifier = Modifier,
    model: Any? = null,
    errorImage: Painter? = null,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.FillBounds,
    colorFilter: ColorFilter? = null,
    alpha: Float = 1f,
) {

    // This variable states if the painter is loading from the URL or is already loaded
    val isLoading = remember { mutableStateOf(true) }

    // This is the AsyncPainterImage
    val painter = rememberAsyncImagePainter(
        model = model,
        onError = {

            // Loading state is turned back to false
            isLoading.value = false
        },
        onSuccess = {

            // Loading state is turned back to false
            isLoading.value = false
        },
        onLoading = {

            // Loading State is turned to true since the loading is started
            isLoading.value = true
        },
    )

    // This is the Fetched image which will be shown when the Image is fetched from the Server
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )


}