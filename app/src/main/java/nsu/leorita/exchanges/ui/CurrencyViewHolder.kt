package nsu.leorita.exchanges.ui

import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.exchanges.databinding.ItemCurrencyBinding
import nsu.leorita.exchanges.domain.model.Currency

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency, onClick: (Currency) -> Unit) {
        binding.nameTextView.text = currency.name
        binding.symbolTextView.text = currency.code
        binding.nominalTextView.text = "%.3f".format(currency.getRange())
        binding.root.setOnClickListener {
            onClick(currency)
        }
    }
}