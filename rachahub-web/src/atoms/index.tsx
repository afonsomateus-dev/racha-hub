import type { Result } from "../types/match";
import type { Player } from "../types/player";
import { initials } from "../utils/helpers";

export function Av({ player, size = "md" }: { player: Player; size?: "sm" | "md" | "lg" | "xl" }) {
  const sz = { sm: "w-8 h-8 text-[10px]", md: "w-10 h-10 text-xs", lg: "w-14 h-14 text-sm", xl: "w-20 h-20 text-lg" }[size];
  return (
    <div
      className={`${sz} rounded-full flex items-center justify-center font-black shrink-0 select-none font-title`}
      style={{ background: `linear-gradient(135deg, ${player.color}22, ${player.color}44)`, border: `1.5px solid ${player.color}55`, color: player.color }}
    >
      {initials(player.nick)}
    </div>
  );
}

export function Pos({ pos }: { pos: string }) {
  return (
    <span className="text-[9px] font-bold px-1.5 py-0.5 rounded bg-white/6 text-white/35 tracking-widest">{pos}</span>
  );
}

export function Dot({ r }: { r: Result }) {
  const c = { W: "bg-[#00E87A]", L: "bg-[#FF3B30]", D: "bg-white/20" }[r];
  return <div className={`w-2 h-2 rounded-full shrink-0 ${c}`} />;
}

export function Medal({ rank }: { rank: number }) {
  if (rank === 1) return <span className="text-2xl leading-none">🥇</span>;
  if (rank === 2) return <span className="text-xl leading-none">🥈</span>;
  if (rank === 3) return <span className="text-xl leading-none">🥉</span>;
  return <span className="text-sm text-white/25 font-bold w-6 text-center inline-block font-title">{rank}</span>;
}