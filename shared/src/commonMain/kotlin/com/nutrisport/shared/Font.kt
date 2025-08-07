package com.nutrisport.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import nutrisport.shared.generated.resources.BebasNeue_Regular
import nutrisport.shared.generated.resources.Res
import nutrisport.shared.generated.resources.RobotoCondensed_VariableFont_wght
import org.jetbrains.compose.resources.Font

@Composable
fun BebasNeueFont() = FontFamily(
   Font(Res.font.BebasNeue_Regular)
)

@Composable
fun RobotoCondensedFont() = FontFamily(
   Font(Res.font.RobotoCondensed_VariableFont_wght)
)

object  FontSize {
   const val EXTRA_SMALL = 10
   const val SMALL = 12
   const val REGULAR = 14
   const val EXTRA_REGULAR = 16
   const val MEDIUM = 18
   const val EXTRA_MEDIUM = 20
   const val LARGE = 30
   const val EXTRA_LARGE = 40
}