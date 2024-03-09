package com.example.aviatickets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aviatickets.R
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.databinding.FragmentOfferListBinding
import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.network.ApiClient
import com.example.aviatickets.model.service.FakeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        setupUI()
//        adapter.setItems(FakeService.offerList)
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        val apiService = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient.ApiService::class.java)

        val offers = apiService.getOffers()

        adapter.setItems(offers)
    }


    private fun setupUI() {
        val apiService = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient.ApiService::class.java)
        val offers = apiService.getOffers()

        with(binding) {
            offerList.adapter = adapter

            sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.sort_by_price -> {
                        val sortedList = offers.sortedBy { it.price }
                        adapter.setItems(sortedList)

                        /**
                         * implement sorting by price
                         */
                    }

                    R.id.sort_by_duration -> {
//                        val sortedList = offers.sortedBy { it.duration }
//                        adapter.setItems(sortedList)

                        /**
                         * implement sorting by duration
                         */
                    }
                }
            }
        }
    }



}