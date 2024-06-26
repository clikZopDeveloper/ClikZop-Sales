package com.clikzop.sales_custom.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clikzop.sales_custom.Model.LeadDetailBean
import com.clikzop.sales_custom.R
import com.clikzop.sales_custom.Utills.RvStatusClickListner


class LeadProdctListAdapter(
    var context: Activity,
    var list: List<LeadDetailBean.Data.LeadProduct>,
    var rvClickListner: RvStatusClickListner
) : RecyclerView.Adapter<LeadProdctListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder { // infalte the item Layout
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lead_inquiry, parent, false)
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



        holder.tvProductName.text = list[position].productName.toString()
        holder.tvDeliveredStatus.text = list[position].isDelivered.toString()
        holder.tvPrice.text = list[position].productPrice.toString()
        holder.tvQty.text = list[position].qty.toString()
        holder.tvDate.text = list[position].createdAt.toString()

        holder.ivDelete.setOnClickListener {
            rvClickListner.clickPos("", list[position].leadId)
        }
        // holder.ivImage.setImageDrawable(context.resources.getDrawable(list[position].drawableId))

        /*  if ("Retailer"=="Retailer"){
        //      holder.itemView.visibility=View.GONE
          }*/


        holder.itemView.setOnClickListener {
            //   rvClickListner.clickPos(list[position].status,list[position].id)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvProductName: TextView = itemview.findViewById(R.id.tvProductName)
        val tvDeliveredStatus: TextView = itemview.findViewById(R.id.tvDeliveredStatus)
        val tvQty: TextView = itemview.findViewById(R.id.tvQty)
        val tvDate: TextView = itemview.findViewById(R.id.tvDate)
        val ivDelete: ImageView = itemview.findViewById(R.id.ivDelete)
        val tvPrice: TextView = itemview.findViewById(R.id.tvPrice)

    }

}