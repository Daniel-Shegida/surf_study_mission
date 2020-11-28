package com.example.surf_kotl_mis1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.myapplication4.api.networkService
import com.example.surf_kotl_mis1.model.LoginPost
import com.example.surf_kotl_mis1.model.LoginService
import com.example.surf_kotl_mis1.model.User
import kotlinx.android.synthetic.main.fragment_meme.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MemeFragment : Fragment(R.layout.fragment_meme) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var message2 : String? = "error"
        message2 = arguments?.getString("messege")
        view.test_text.text = message2

        view.button4.setOnClickListener {

            var newView: ImageView

            newView = ImageView(getActivity())
            view.lay.addView(newView)
            newView.layoutParams.height = 200
            newView.layoutParams.width = 200
            newView.x = 300F
            newView.y = 500F
            newView.setBackgroundColor(Color.MAGENTA)
        }


    }
}


/*   // TODO: Rename and change types of parameters
   private var param1: String? = null
   private var param2: String? = null

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       arguments?.let {
           param1 = it.getString(ARG_PARAM1)
           param2 = it.getString(ARG_PARAM2)
       }
   }

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {
       // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_meme, container, false)
       var message2 : String? = "error"
       message2 = arguments?.getString("messege")
       view.test_text.setText("message2")


       return view
   }

   companion object {
       /**
        * Use this factory method to create a new instance of
        * this fragment using the provided parameters.
        *
        * @param param1 Parameter 1.
        * @param param2 Parameter 2.
        * @return A new instance of fragment MemeFragment.
        */
       // TODO: Rename and change types and number of parameters
       @JvmStatic
       fun newInstance(param1: String, param2: String) =
           MemeFragment().apply {
               arguments = Bundle().apply {
                   putString(ARG_PARAM1, param1)
                   putString(ARG_PARAM2, param2)
               }
           }
   }
}
*/
