import type { PlayerWinRateBarProps } from "@types";
import { winRate } from "@utils";
import { TrendingUp } from "lucide-react";

export const PlayerWinRateBar = ({ player }: PlayerWinRateBarProps) => {
  const rate = winRate(player);
  
  return (
    <div className="rounded-2xl p-5 mb-4" style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}>
      <div className="flex items-center justify-between mb-3">
        <div className="flex items-center gap-2">
          <TrendingUp className="w-3.5 h-3.5 text-[#00E87A]" />
          <span className="text-xs font-bold text-white/50 uppercase tracking-widest">Aproveitamento</span>
        </div>
        <span className="text-2xl font-black text-[#00E87A] font-title">{rate}%</span>
      </div>
      <div className="h-2 bg-white/5 rounded-full overflow-hidden">
        <div
          className="h-full rounded-full transition-all duration-700"
          style={{ width: `${rate}%`, background: `linear-gradient(90deg, ${player.color}88, ${player.color})` }}
        />
      </div>
      <div className="flex justify-between mt-2 text-[9px] text-white/20">
        <span>{player.wins}V · {player.draws}E · {player.losses}D</span>
        <span>{player.apps} jogos</span>
      </div>
    </div>
  );
}