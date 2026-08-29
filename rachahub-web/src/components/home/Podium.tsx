import type { CSSProperties } from "react";
import { Av } from "../../atoms";
import type { PodiumProps } from "../../types/general";

const D: CSSProperties = { fontFamily: "'Barlow Condensed', sans-serif" };

export const Podium = ({ playersByWin }: PodiumProps) => {
  const [p1, p2, p3] = playersByWin;

  return (
    <div>
      <div className="flex items-center justify-between mb-3">
        <h2 className="text-[10px] font-bold text-white/40 uppercase tracking-[0.18em]">Pódio da Temporada</h2>
        <span className="text-[9px] text-white/20">Vitórias</span>
      </div>
      <div className="grid grid-cols-3 gap-2 items-end">
        <div
          className="rounded-2xl p-3 flex flex-col items-center gap-2 cursor-pointer active:scale-95 transition-transform"
          style={{ background: "#141419", border: "1px solid rgba(192,192,192,0.14)" }}
          onClick={() => {}}
        >
          <span className="text-xl">🥈</span>
          <Av player={p2} size="md" />
          <div className="text-center">
            <div className="text-xs font-black text-white/80 leading-tight" style={D}>{p2.nick}</div>
            <div className="text-[10px] text-white/30 font-semibold">{p2.wins}V</div>
          </div>
        </div>
        <div
          className="rounded-2xl p-3 flex flex-col items-center gap-2 cursor-pointer active:scale-95 transition-transform -mt-4"
          style={{ background: "linear-gradient(155deg, #1e1a0e, #14120a)", border: "1px solid rgba(255,184,0,0.28)" }}
          onClick={() => {}}
        >
          <span className="text-2xl">🥇</span>
          <Av player={p1} size="lg" />
          <div className="text-center">
            <div className="text-sm font-black text-white leading-tight" style={D}>{p1.nick}</div>
            <div className="text-xs text-[#FFB800] font-black" style={D}>{p1.wins}V</div>
          </div>
        </div>
        <div
          className="rounded-2xl p-3 flex flex-col items-center gap-2 cursor-pointer active:scale-95 transition-transform"
          style={{ background: "#141419", border: "1px solid rgba(205,127,50,0.14)" }}
          onClick={() => {}}
        >
          <span className="text-xl">🥉</span>
          <Av player={p3} size="md" />
          <div className="text-center">
            <div className="text-xs font-black text-white/80 leading-tight" style={D}>{p3.nick}</div>
            <div className="text-[10px] text-white/30 font-semibold">{p3.wins}V</div>
          </div>
        </div>
      </div>
    </div>
);
}