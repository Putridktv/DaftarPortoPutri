package id.utdi.putridwioktaviani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.utdi.putridwioktaviani.data.Datasource
import id.utdi.putridwioktaviani.model.Affirmation
import id.utdi.putridwioktaviani.ui.theme.DaftarPortoPutriTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaftarPortoPutriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() { //fungsi untuk menampung meanmpilkan aplikasi
    AffirmationList(
        affirmationList = Datasource().loadAffirmations(), //memanggil fungsi affirmationlist
    )
}

@Composable //fungsi untuk membuat tampilan tiap item
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = Modifier //menggunakan card agar pembuatan list leboih cepat
        .fillMaxWidth() //agar card menyesuaikan layar
        .padding(8.dp) //menambahkan jarak antar card/item
    ) {
        Column {
            Row {//menggunakan row untuk mensejajarkan gambar dengan tulisan
                Image(
                    painter = painterResource(affirmation.imageResourceId), //mengimport gambar menggunakan val imageResourceid dalam Datsource
                    contentDescription = stringResource(affirmation.stringResourceId), //mengimport tekks dengan val stringgresourceId dalam file strings.xml
                    modifier = Modifier //menggunakan modifier untuk mengatyur tampilan
                        .size(width = 100.dp, height = 100.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.FillHeight //untuk scalable gambar menyesuaikan tinggi card
                )

                Text( //menambahkan teks dalam items
                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {//fungsi untuk membuat list
        items(affirmationList) { affirmation -> //menggunakan laxy list items
            AffirmationCard( //memanghgil fungsi affirmationcard
                affirmation = affirmation,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Preview //fungsi untuk preview tanpa harus menjalankan emulator
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image_1))
}



