import type { PlayerStatsGridProps } from "@types";

export const PlayerStatsGrid = ({ player }: PlayerStatsGridProps) => {
  return (
    <div className="grid grid-cols-3 gap-2 mb-4">
      {[
        { l: "Jogos", v: player.apps, c: "#f0f0f5" },
        { l: "Vitórias", v: player.wins, c: "#00E87A" },
        { l: "Derrotas", v: player.losses, c: "#FF3B30" },
        { l: "Empates", v: player.draws, c: "#5c5c70" },
        { l: "Gols", v: player.goals, c: "#FFB800" },
        { l: "Sequência", v: player.streak, c: "#F97316" },
      ].map(s => (
        <div key={s.l} className="rounded-2xl p-4 text-center" style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}>
          <div className="text-3xl font-black leading-none mb-1 font-title" style={{ color: s.c }}>{s.v}</div>
          <div className="text-[9px] text-white/25 uppercase tracking-wider">{s.l}</div>
        </div>
      ))}
    </div>
  );
}