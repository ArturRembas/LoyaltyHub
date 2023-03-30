package it.unicam.cs.ids.LoyaltyHub.app;

import org.springframework.data.repository.CrudRepository;

/**
 * RewardRepository interface extends CrudRepository for managing Reward entities.
 */
public interface RewardRepository extends CrudRepository<Reward, Integer> {
}


/*
package it.unicam.cs.ids.LoyaltyHub.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RewardRepository {

	private List<Reward> rewards;

    public RewardRepository() {
        this.rewards = new ArrayList<>();
    }

    // Aggiungi una nuova ricompensa al repository
    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    // Trova una ricompensa nel repository utilizzando l'ID
    public Optional<Reward> findRewardById(int id) {
        return rewards.stream().filter(reward -> reward.getId() == id).findFirst();
    }

    // Aggiorna una ricompensa nel repository
    public void updateReward(Reward updatedReward) {
        int index = -1;
        for (int i = 0; i < rewards.size(); i++) {
            if (rewards.get(i).getId() == updatedReward.getId()) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            rewards.set(index, updatedReward);
        }
    }

    // Rimuovi una ricompensa dal repository utilizzando l'ID
    public void removeReward(int id) {
        rewards.removeIf(reward -> reward.getId() == id);
    }

    // Recupera tutte le ricompense dal repository
    public List<Reward> findAllRewards() {
        return new ArrayList<>(rewards);
    }
}
*/