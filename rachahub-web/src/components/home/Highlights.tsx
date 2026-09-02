import { Flame, Target, Trophy, Users } from "lucide-react";
import { Av } from "@atoms";
import type { HighlightsProps } from "@types";

export const Highlights = ({ players }: HighlightsProps) => {
  const topGoals = [...players].sort((a, b) => b.goals - a.goals)[0];
  const topApps = [...players].sort((a, b) => b.apps - a.apps)[0];
  const topStreak = [...players].sort((a, b) => b.streak - a.streak)[0];
  const byWins = [...players].sort((a, b) => b.wins - a.wins);
  const [p1, p2, p3] = byWins;

  return (
    <div>
      <h2 className="text-[10px] font-bold text-white/40 uppercase tracking-[0.18em] mb-3">Destaques</h2>
      <div className="flex gap-3 overflow-x-auto -mx-4 px-4 pb-1" style={{ scrollbarWidth: "none" }}>
        {[
          { icon: <Target className="w-3.5 h-3.5 text-[#00E87A]" />, label: "Artilheiro", value: topGoals.goals, unit: "gols", player: topGoals, color: "#00E87A" },
          { icon: <Trophy className="w-3.5 h-3.5 text-[#FFB800]" />, label: "Mais Vitórias", value: p1.wins, unit: "vitórias", player: p1, color: "#FFB800" },
          { icon: <Users className="w-3.5 h-3.5 text-[#3B82F6]" />, label: "Presença", value: topApps.apps, unit: "jogos", player: topApps, color: "#3B82F6" },
          { icon: <Flame className="w-3.5 h-3.5 text-[#F97316]" />, label: "Em Chamas", value: topStreak.streak, unit: "sequência", player: topStreak, color: "#F97316" },
        ].map(s => (
          <div
            key={s.label}
            className="shrink-0 w-40 rounded-2xl p-4 cursor-pointer active:scale-95 transition-transform"
            style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}
            onClick={() => {}}
          >
            <div className="flex items-center gap-1.5 mb-3">{s.icon}<span className="text-[9px] text-white/30 uppercase tracking-wider">{s.label}</span></div>
            <div className="text-4xl font-black text-white mb-0.5 leading-none font-title" style={{ color: s.color }}>{s.value}</div>
            <div className="text-[9px] text-white/25 mb-3">{s.unit}</div>
            <div className="flex items-center gap-1.5">
              <Av player={s.player} size="sm" />
              <span className="text-xs font-bold text-white/70 truncate font-title">{s.player.nick}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}