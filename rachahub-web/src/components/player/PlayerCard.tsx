import { Av, Dot, Pos } from "@atoms";
import type { PlayerCardProps } from "@types";
import { Flame } from "lucide-react";

export const PlayerCard = ({ player }: PlayerCardProps) => {
  return (
    <div
      className="rounded-3xl p-6 mb-5 relative overflow-hidden"
      style={{ background: `linear-gradient(145deg, ${player?.color}14, #141419 55%)`, border: `1px solid ${player?.color}30` }}
    >
      <div className="absolute right-3 top-0 font-black text-[9rem] leading-none opacity-[0.06] select-none pointer-events-none font-title" style={{ color: player.color }}>
        {player?.goals}
      </div>
      <div className="flex items-start gap-4 relative z-10">
        <Av player={player} size="xl" />
        <div className="flex-1 min-w-0">
          <div className="flex items-center gap-2 mb-1.5 flex-wrap">
            <Pos pos={player.pos} />
            {player.streak >= 3 && (
              <div className="flex items-center gap-1 bg-[#F97316]/12 text-[#F97316] text-[9px] font-bold px-2 py-0.5 rounded-full">
                <Flame className="w-2.5 h-2.5" />EM CHAMAS
              </div>
            )}
          </div>
          <h1 className="text-4xl font-black text-white leading-none mb-1 font-title">{player.nick}</h1>
          <div className="text-xs text-white/30 mb-3">{player.name}</div>
          <div className="flex items-center gap-1.5">
            {player.lastResults.map((r, i) => <Dot key={i} r={r} />)}
            <span className="text-[9px] text-white/20 ml-1">últimos 5</span>
          </div>
        </div>
      </div>
    </div>
  );
}