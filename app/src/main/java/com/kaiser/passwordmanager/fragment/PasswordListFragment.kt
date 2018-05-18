package com.kaiser.passwordmanager.fragment


import android.os.Bundle
import android.app.Fragment
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.kaiser.passwordmanager.R
import com.kaiser.passwordmanager.activity.utils.toast
import kotlinx.android.synthetic.main.bottom_dialog_modal_sheet.*
import kotlinx.android.synthetic.main.fragment_password_list.*

class PasswordListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var view_root = view?.findViewById<ConstraintLayout>(R.id.bottom_sheet_root)

        txt_add_credentials.setOnClickListener {
            var sheetBehavior = BottomSheetBehavior.from(view_root)
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }
        view_root?.findViewById<Button>(R.id.btn_add_credentials)?.setOnClickListener {
            activity?.toast("Saved")
        }
    }
}
