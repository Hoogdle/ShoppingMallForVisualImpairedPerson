import android.Manifest
import android.R.attr.singleLine
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.unifiedshoppingmall.R
import com.example.unifiedshoppingmall.ui.theme.MainBlue
import java.util.Locale

@Composable
fun SearchwithVocie(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var prompt by remember { mutableStateOf("") }

    // Launcher for speech recognition
    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            val spokenText =
                result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.firstOrNull()
            if (spokenText != null) {
                prompt = spokenText  // Update prompt with recognized text
            } else {
                Toast.makeText(context, "음성인식에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            BasicTextField(
                textStyle = TextStyle.Default.copy(fontSize = 40.sp),

                value = prompt,
                onValueChange = { prompt = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        vertical = 8.dp,
                        horizontal = 2.dp)
                    .background(Color.White)
                    .height(70.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (prompt.isEmpty()) {
                        Text("상품검색",
                            color = Color.Gray,
                            fontFamily = FontFamily(Font(R.font.main_bold)),
                            fontSize = 30.sp,
                            modifier = Modifier.padding(15.dp))
                    }
                    innerTextField()
                }
            )


            // Add a button to start voice recognition
            Button(
                shape = RectangleShape,
                onClick = {
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.RECORD_AUDIO
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                        intent.putExtra(
                            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                        )
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성인식 중..")
                        speechRecognizerLauncher.launch(intent)
                    } else {
                        ActivityCompat.requestPermissions(
                            context as Activity,
                            arrayOf(Manifest.permission.RECORD_AUDIO),
                            100
                        )
                    }
                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .width(100.dp)
                    .height(70.dp),
                colors = ButtonColors(
                    containerColor = MainBlue,
                    contentColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = MainBlue)
            ) {
                Text(
                    "음성검색",
                    fontFamily = FontFamily(Font(R.font.main_bold)),
                    fontSize = 12.sp,
                )
            }
        }
    }
}


