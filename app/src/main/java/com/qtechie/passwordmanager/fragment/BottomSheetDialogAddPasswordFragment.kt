package com.qtechie.passwordmanager.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.qtechie.passwordmanager.R

class BottomSheetDialogAddPasswordFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_bottom_sheet_dialog_add_password, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        fun newInstance(param1: String, param2: String): BottomSheetDialogAddPasswordFragment {
            return BottomSheetDialogAddPasswordFragment()
        }
    }
}// Required empty public constructor
