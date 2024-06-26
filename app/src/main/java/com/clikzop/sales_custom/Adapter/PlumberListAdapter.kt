package com.clikzop.sales_custom.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clikzop.sales_custom.Model.InstallerBean
import com.clikzop.sales_custom.R
import com.clikzop.sales_custom.Utills.RvPlumberListner


class PlumberListAdapter(var context: Activity, var mlist: List<InstallerBean.Data>, var rvClickListner: RvPlumberListner) : RecyclerView.Adapter<PlumberListAdapter.MyViewHolder>(),
    Filterable {
    var mFilteredList: MutableList<InstallerBean.Data> = mlist as MutableList<InstallerBean.Data>
    var doa = ""
    var dob = ""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // infalte the item Layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_client_list, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)

   /*     holder.tvAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvQtyAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQtyMinus.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQty.background = RoundView(Color.TRANSPARENT, RoundView.getRadius(20f), true, R.color.orange)
        holder.tvOff.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvAdd.visibility = View.VISIBLE*/

        holder.tvClientName.text=mFilteredList[position].name.toString()+" / "+mFilteredList[position].number.toString()

        holder.ivEditClient.setOnClickListener {
            rvClickListner.clickPos(
                mFilteredList.get(position).name,
                mFilteredList.get(position).number,
                mFilteredList.get(position).state,
                mFilteredList.get(position).city,
                mFilteredList.get(position).address,
                mFilteredList[position].id,mFilteredList[position].doa,mFilteredList[position].dob)
        }
       // holder.ivImage.setImageDrawable(context.resources.getDrawable(list[position].drawableId))

      /*  if ("Retailer"=="Retailer"){
      //      holder.itemView.visibility=View.GONE
        }*/

     /*   holder.itemView.setOnClickListener {
            rvClickListner.clickPos(list[position].status,list[position].id)
        }*/
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvClientName: TextView = itemview.findViewById(R.id.tvClientName)
        val ivEditClient: ImageView = itemview.findViewById(R.id.ivEditClient)

    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    mFilteredList = mlist as MutableList<InstallerBean.Data>
                } else {
                    val filteredList = ArrayList<InstallerBean.Data>()
                    for (serviceBean in mlist) {
                        if (serviceBean.name.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(serviceBean)
                        }
                    }
                    mFilteredList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = mFilteredList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                mFilteredList = filterResults.values as ArrayList<InstallerBean.Data>
                android.os.Handler().postDelayed(Runnable { notifyDataSetChanged() }, 200)
            }
        }
    }
}