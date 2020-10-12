package com.rbugarin.myfirstdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val contacts : List<ContactData>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    class ContactViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        fun onBind(contactData: ContactData){
            val textViewName = view.findViewById<TextView>(R.id.textView_name)
            val textViewLastName = view.findViewById<TextView>(R.id.textView_lastname)
            val textViewAge = view.findViewById<TextView>(R.id.textView_age)

            textViewName.text = contactData.name
            textViewLastName.text = contactData.lastName
            textViewAge.text = contactData.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.onBind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}