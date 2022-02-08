package com.nftworlds.wallet.contracts.nftworlds;

import com.nftworlds.wallet.NFTWorlds;
import com.nftworlds.wallet.contracts.wrappers.polygon.PolygonPlayers;
import org.json.simple.JSONObject;

import java.util.List;

public class Players {
    private PolygonPlayers polygonPlayersContract;

    public Players() {
        this.polygonPlayersContract = PolygonPlayers.load(NFTWorlds.getInstance().getNftConfig().getPolygonPlayerContract());
    }

    //NOTE: All of these lookups can initially be done async on the join event (When a new instance of NFTPlayer is created). Then they'll be cached.

    public String getPlayerPrimaryWallet(String playerUUID) throws Exception {
        // TODO: returns async? or?
        return this.polygonPlayersContract.getPlayerPrimaryWallet(playerUUID).send();
    }

    public List<String> getPlayerSecondaryWallets(String playerUUID) throws Exception {
        // TODO: returns async? or?
        return this.polygonPlayersContract.getPlayerSecondaryWallets(playerUUID).send();
    }

    public JSONObject getPlayerStateData(String playerUUID, String setterWalletAddress) throws Exception {
        // TODO: returns async? or?
        String stateDataUrl = this.polygonPlayersContract.getPlayerStateData(playerUUID, setterWalletAddress, true).send();

        if (stateDataUrl.isEmpty()) {
            // TODO: no state data was set for player by the setter address, return?
        }

        /*
            TODO:
            Do HTTP request for JSON string returned from retrieving stateDataUrl contents.
            Convert JSON string to JSON Object and return.
         */
    }
}
