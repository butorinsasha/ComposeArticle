package local.pushkin.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import local.pushkin.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleCard(
                        imageRes = R.drawable.bg_compose_background,
                        title = stringResource(id = R.string.title),
                        shortDescription = stringResource(id = R.string.short_description),
                        longDescription = stringResource(id = R.string.long_description),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticleCard(
    imageRes: Int,
    title: String,
    shortDescription: String,
    longDescription: String,
    modifier: Modifier,
) {
    Column(modifier) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = modifier
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)

        )
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposeArticleCardPreview() {
    ComposeArticleTheme {
        ComposeArticleCard(
            imageRes = R.drawable.bg_compose_background,
            title = stringResource(R.string.title),
            shortDescription = stringResource(R.string.short_description),
            longDescription = stringResource(R.string.long_description),
            modifier = Modifier
        )
    }
}