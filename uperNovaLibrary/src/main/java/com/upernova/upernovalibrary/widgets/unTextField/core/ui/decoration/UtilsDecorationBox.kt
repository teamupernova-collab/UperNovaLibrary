package com.example.textinputkitlibrary.core.uitextfield.decoration

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.upernova.upernovalibrary.theme.ui.ErrorRed
import com.upernova.upernovalibrary.theme.ui.NightBlue
import com.upernova.upernovalibrary.theme.ui.PetrolBlue
import com.upernova.upernovalibrary.theme.ui.SuccessGreen
import com.upernova.upernovalibrary.theme.ui.WarningAmber
import com.upernova.upernovalibrary.theme.ui.gray500ColorBox
import com.upernova.upernovalibrary.widgets.unTextField.core.base.TextFieldStatus
import org.jetbrains.annotations.ApiStatus.Internal


@Internal
fun getUnderLineBox(focusState: Boolean, textFieldStatus: TextFieldStatus): Color {
    return when (focusState) {
        true -> {
            when (textFieldStatus) {
                TextFieldStatus.ERROR -> ErrorRed
                TextFieldStatus.SUCCESS -> SuccessGreen
                TextFieldStatus.WARNING -> WarningAmber
                else -> PetrolBlue
            }
        }

        false -> {
            when (textFieldStatus) {
                TextFieldStatus.ERROR -> ErrorRed
                TextFieldStatus.SUCCESS -> SuccessGreen
                TextFieldStatus.WARNING -> WarningAmber
                TextFieldStatus.DISABLE -> gray500ColorBox
                else -> NightBlue
            }
        }
    }
}


@Internal
fun getUnderLineHeightBox(
    focusState: Boolean,
    value: String,
): Dp {
    return when (focusState) {
        true -> {
            Dp(1.0F)
        }

        false -> {
            if (value.isNotEmpty()) {
                Dp(1.0F)
            } else {
                Dp(0.5F)
            }
        }
    }
}