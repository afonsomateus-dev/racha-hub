import { PlayerCard, PlayerGoalsChart, PlayerStatsGrid, PlayerWinRateBar } from "@components";
import { PLAYERS } from "../../constants";
import { useParams } from "react-router";


export const PlayerProfileScreen = () => {
  const { id } = useParams();

  const player = PLAYERS.find(p => p.id === Number(id)) ?? PLAYERS[0];
  
  const rankGoals = [...PLAYERS].sort((a, b) => b.goals - a.goals).findIndex(p => p.id === player?.id) + 1;
  const rankWins = [...PLAYERS].sort((a, b) => b.wins - a.wins).findIndex(p => p.id === player?.id) + 1;

  return (
    <div className="px-5 pb-20">
      <PlayerCard player={player} />

      <PlayerStatsGrid player={player} />        

      <PlayerWinRateBar player={player} />

      <div className="grid grid-cols-2 gap-3 mb-4">
        <div className="rounded-2xl p-4" style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}>
          <div className="text-[9px] text-white/25 uppercase tracking-widest mb-2">Rank Gols</div>
          <div className="flex items-baseline gap-1">
            <span className="text-4xl font-black text-white font-title">#{rankGoals}</span>
            <span className="text-xs text-white/20">de {PLAYERS.length}</span>
          </div>
          <div className="text-xs text-[#FFB800] font-bold mt-1 font-title">{player.goals} gols</div>
        </div>
        <div className="rounded-2xl p-4" style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}>
          <div className="text-[9px] text-white/25 uppercase tracking-widest mb-2">Rank Vitórias</div>
          <div className="flex items-baseline gap-1">
            <span className="text-4xl font-black text-white font-title">#{rankWins}</span>
            <span className="text-xs text-white/20">de {PLAYERS.length}</span>
          </div>
          <div className="text-xs text-[#00E87A] font-bold mt-1 font-title">{player.wins} vitórias</div>
        </div>
      </div>
      
      <PlayerGoalsChart player={player} />
    </div>
  );
}