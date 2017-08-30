package datas

data class ComputePreference(
        val venueId: String,
        val rank: Int
)
data class ComputeUserPreferences(
    val preferences: List<ComputePreference>
)