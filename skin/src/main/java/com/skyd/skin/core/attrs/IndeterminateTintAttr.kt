package com.skyd.skin.core.attrs

import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.skyd.skin.core.SkinResourceProcessor

class IndeterminateTintAttr : SkinAttr() {
    override fun applySkin(view: View) {
        if (attrResourceRefId != -1 && view is ProgressBar) {
            val skinResProcessor = SkinResourceProcessor.instance
            if (skinResProcessor.usingDefaultSkin() && skinResProcessor.usingInnerAppSkin()) {
                view.indeterminateTintList =
                    ContextCompat.getColorStateList(view.context, attrResourceRefId)
            } else {
                view.indeterminateTintList = skinResProcessor.getColorStateList(attrResourceRefId)
            }
        }
    }

    override fun tag(): String = "indeterminateTint"
}