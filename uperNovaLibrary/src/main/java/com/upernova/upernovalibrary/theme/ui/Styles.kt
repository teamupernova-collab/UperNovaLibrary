package com.example.textinputkitlibrary.utils.ui

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.upernova.upernovalibrary.R
import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
object Styles {
    private val robotoFontFamily = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold),
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_medium, FontWeight.Medium)
    )


    var roboto16Medium = TextStyle(
        fontSize = DimensSp.Sp16,
        lineHeight = DimensSp.Sp24,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
    )
    var roboto10Medium = TextStyle(
        fontSize = DimensSp.Sp10,
        lineHeight = DimensSp.Sp16,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    var roboto16Regular = TextStyle(
        fontSize = DimensSp.Sp16,
        fontWeight = FontWeight.Normal,
        fontFamily = robotoFontFamily,
        lineHeight = DimensSp.Sp24,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    )
    var roboto14Regular = TextStyle(
        fontSize = DimensSp.Sp14,
        fontWeight = FontWeight.Normal,
        fontFamily = robotoFontFamily,
        lineHeight = DimensSp.Sp16
    )

    var roboto10Thin = TextStyle(
        fontSize = DimensSp.Sp14,
        fontWeight = FontWeight.Thin,
        fontFamily = robotoFontFamily,
        lineHeight = DimensSp.Sp10
    )

}