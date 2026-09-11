package com.upernova.upernovalibrary.widgets.unButton.core.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.textinputkitlibrary.utils.ui.Styles.roboto12Thin
import com.example.textinputkitlibrary.utils.ui.Styles.roboto16Regular
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp1
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp10
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp18
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp20
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp35
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp4
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp45
import com.upernova.upernovalibrary.theme.ui.DimensDp.Dp6
import com.upernova.upernovalibrary.theme.ui.LightGray
import com.upernova.upernovalibrary.theme.ui.PetrolBlue
import com.upernova.upernovalibrary.widgets.unButton.core.base.ButtonStatus
import com.upernova.upernovalibrary.widgets.unButton.core.base.ButtonType
import com.upernova.upernovalibrary.widgets.unButton.core.model.ButtonModel
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

        ButtonType.TERTIARY -> {
            val interactionSource = remember { MutableInteractionSource() }
            Row(
                modifier = modifier
                    .drawWithContent {
                        drawContent()
                        drawLine(
                            color = PetrolBlue,
                            start = Offset(
                                0f,
                                size.height + Dp4
                                    .toPx()
                            ),
                            end = Offset(
                                size.width,
                                size.height + Dp4
                                    .toPx()
                            ),
                            strokeWidth = 2f
                        )
                    }
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onClickListener()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                if (buttonModel.buttonIcon != null) {
                    Image(
                        painter = painterResource(id = buttonModel.buttonIcon), contentDescription = "",
                        modifier = Modifier
                            .padding(end = Dp10)
                            .height(Dp18)
                            .width(Dp18),
                        colorFilter = ColorFilter.tint(PetrolBlue )
                    )
                }
                Text(
                    text = buttonModel.buttonLabel, modifier = Modifier,
                    style = roboto12Thin,
                    color = PetrolBlue
                )
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