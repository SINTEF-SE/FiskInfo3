package no.sintef.fiskinfo.ui.tools

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import no.sintef.fiskinfo.model.fishingfacility.FishingFacility
import no.sintef.fiskinfo.repository.FishingFacilityRepository

class ToolsViewModel(application: Application) : AndroidViewModel(application)  {

    private val selectedTool = MutableLiveData<FishingFacility?>()
    private var confirmedTools: LiveData<List<FishingFacility>>? = null
    private var unconfirmedTools: LiveData<List<FishingFacility>>? = null



    fun selectSnap(tool: FishingFacility?, isConfirmed: Boolean) {
        //selectedIsIncomming.value = isConfirmed
        selectedTool.value = tool
    }

    fun getSelectedSnap(): LiveData<FishingFacility?> {
        return selectedTool
    }


    fun getConfirmedTools(): LiveData<List<FishingFacility>>? {
        if (confirmedTools == null) {
            confirmedTools = FishingFacilityRepository.getInstance(getApplication()).confirmedTools
        }
        return confirmedTools
    }

    fun getUnconfirmedTools(): LiveData<List<FishingFacility>>? {
        if (unconfirmedTools == null) {
            unconfirmedTools = FishingFacilityRepository.getInstance(getApplication()).unconfirmedTools
        }
        return unconfirmedTools
    }

}
