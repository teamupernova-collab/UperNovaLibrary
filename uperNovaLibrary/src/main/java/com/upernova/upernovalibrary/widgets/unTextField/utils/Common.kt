package com.upernova.upernovalibrary.widgets.unTextField.utils

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.textinputkitlibrary.utils.ui.CharcoalGray
import com.example.textinputkitlibrary.utils.ui.ErrorRed
import com.example.textinputkitlibrary.utils.ui.Styles.roboto10Thin
import com.example.textinputkitlibrary.utils.ui.SuccessGreen
import com.example.textinputkitlibrary.utils.ui.WarningAmber
import com.upernova.upernovalibrary.widgets.unTextField.core.base.KeyBoardActions
import com.upernova.upernovalibrary.widgets.unTextField.core.base.TextFieldStatus
import com.upernova.upernovalibrary.widgets.unTextField.core.model.TypesIcons
import org.jetbrains.annotations.ApiStatus.Internal
import java.math.RoundingMode.DOWN
import java.text.DecimalFormat
import java.util.Locale

@Internal
const val keyboardMoneyPermit ="$.,1234567890"

@Internal
fun Double.formatMoney(): String {
    val format = DecimalFormat.getCurrencyInstance(Locale.forLanguageTag("es-MX"))
    format.minimumFractionDigits = 0
    format.roundingMode = DOWN
    return format.format(this).trim()
}

private fun getHelperTextStyle(texColor: Color) = roboto10Thin.copy(color = texColor)

@Internal
@Composable
fun getTextStyleState(textFieldStatus: TextFieldStatus): TextStyle {
    return when (textFieldStatus) {
        TextFieldStatus.SUCCESS -> getHelperTextStyle(SuccessGreen)
        TextFieldStatus.ERROR -> getHelperTextStyle(ErrorRed)
        TextFieldStatus.WARNING -> getHelperTextStyle(WarningAmber)
        else -> getHelperTextStyle(CharcoalGray)
    }
}


fun buildKeyboardActions(
    callback: (KeyBoardActions) -> Unit
): KeyboardActions {
    return KeyboardActions(
        onDone = { callback(KeyBoardActions.ON_DONE) },
        onNext = { callback(KeyBoardActions.ON_NEXT) },
        onGo = { callback(KeyBoardActions.ON_GO) },
        onSend = { callback(KeyBoardActions.ON_SEND) },
        onPrevious = { callback(KeyBoardActions.ON_PREVIOUS) },
        onSearch = { callback(KeyBoardActions.ON_SEARCH) }
    )
}


@Internal
fun getIconByStatus(textFieldStatus: TextFieldStatus, dsTypesIcons: TypesIcons): Int? {
    return when(textFieldStatus){
        TextFieldStatus.ERROR -> dsTypesIcons.errorIcon ?: dsTypesIcons.endIcon
        TextFieldStatus.SUCCESS -> dsTypesIcons.successIcon ?: dsTypesIcons.endIcon
        TextFieldStatus.WARNING -> dsTypesIcons.warning ?: dsTypesIcons.endIcon
        else ->{
            dsTypesIcons.endIcon
        }
    }
}