package id.utdi.putridwioktaviani.data

import id.utdi.putridwioktaviani.R
import id.utdi.putridwioktaviani.model.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image_1),
            Affirmation(R.string.affirmation2, R.drawable.image_2),
            Affirmation(R.string.affirmation3, R.drawable.image_3),
            Affirmation(R.string.affirmation4, R.drawable.image_4),
            Affirmation(R.string.affirmation5, R.drawable.image_5),
            Affirmation(R.string.affirmation6, R.drawable.image_6),
            Affirmation(R.string.affirmation7, R.drawable.image_7),
            Affirmation(R.string.affirmation8, R.drawable.image_8),
            Affirmation(R.string.affirmation9, R.drawable.image_9),
            Affirmation(R.string.affirmation10, R.drawable.image_10))
    }
}
