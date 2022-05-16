package emvparser.luis.clip.emvparser

import android.app.Dialog
import android.app.DialogFragment
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.core.content.res.ResourcesCompat
import emvparser.luis.clip.emvparser.models.Tag


class TagListDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL,R.style.fullscreen_dialog)
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog = dialog
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window?.setLayout(width,height)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val regularFont: Typeface? = ResourcesCompat.getFont(context, R.font.dinpro_regular)
        val listView = inflater!!.inflate(R.layout.decoded_data_list,container,false)
        val rowList = listView.findViewById<ListView>(R.id.tlv_list)
        //val tagList2 = arguments.getParcelableArrayList<Tag>("tagList")
        val tagList = arguments.getParcelableArrayList<Tag>("tagList")
        //val tagList: ArrayList<Tag> = arguments.getParcelableArrayList<Tag>("tagList")
        //val adapter = TlvAdapter(context, tagList,regularFont)
        val adapter = tagList?.let { TlvAdapter(context, it,regularFont) }
        rowList.adapter = adapter

        return listView
    }


}