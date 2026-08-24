package com.upernova.upernovalibrary.widgets.unTemplate.core.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp1
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp20
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp35
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp45
import com.example.textinputkitlibrary.utils.ui.DimensDp.Dp6
import com.example.textinputkitlibrary.utils.ui.LightGray
import com.example.textinputkitlibrary.utils.ui.PetrolBlue
import com.example.textinputkitlibrary.utils.ui.Styles.roboto12Thin
import com.example.textinputkitlibrary.utils.ui.Styles.roboto16Regular
import com.upernova.upernovalibrary.widgets.unTemplate.core.base.ButtonStatus
import com.upernova.upernovalibrary.widgets.unTemplate.core.base.ButtonType
import com.upernova.upernovalibrary.widgets.unTemplate.core.model.ButtonModel
import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
@Composable
fun BaseButtonComposeView(
    buttonModel: ButtonModel,
    modifier: Modifier,
    buttonType: ButtonType,
    onClickListener: () -> Unit,
) {
    when (buttonType) {
        ButtonType.PRIMARY -> {
            Button(
                onClick = {
                    onClickListener()
                },
                shape = RoundedCornerShape(Dp6),
                enabled = enableButtonsStatus(buttonModel.buttonStatus),
                modifier = modifier.height(Dp45),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PetrolBlue,
                    disabledContainerColor = LightGray
                )
            ) {
                Text(text = buttonModel.buttonLabel, style = roboto16Regular)
            }
        }

        ButtonType.SECONDARY -> {
            OutlinedButton(
                onClick = {
                    onClickListener()
                }, shape = RoundedCornerShape(Dp20),
                enabled = enableButtonsStatus(buttonModel.buttonStatus),
                modifier = modifier.height(Dp35),
                border = BorderStroke(Dp1, PetrolBlue),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = PetrolBlue,
                )
            ) {
                Text(text = buttonModel.buttonLabel, style = roboto12Thin)
            }
        }
    }
}


private fun enableButtonsStatus(buttonStatus: ButtonStatus): Boolean {
    return when (buttonStatus) {
        ButtonStatus.ENABLE -> true
        ButtonStatus.DISABLE -> false
    }
}


