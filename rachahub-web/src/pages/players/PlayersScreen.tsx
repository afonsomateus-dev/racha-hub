import { useState } from "react";
import { PLAYERS } from "../../constants";
import { useNavigate } from "react-router";
import { Av, Dot, Pos } from "@atoms";
import { ChevronRight } from "lucide-react";


export const PlayersScreen = () => {
  const [q, setQ] = useState("");
  const filtered = PLAYERS.filter(p =>
    p.name.toLowerCase().includes(q.toLowerCase()) ||
    p.nick.toLowerCase().includes(q.toLowerCase())
  );
  const navigate = useNavigate();

  const handleNavigate = (id: number) => {
    console.log('entrou');

    navigate(`/players/${id}`);
  }

  return (
    <div className="flex flex-col gap-4 pb-4">
      <div className="flex items-baseline justify-between pt-1">
        <h1 className="text-3xl font-black text-white font-title">JOGADORES</h1>
        <span className="text-xs text-white/25">{PLAYERS.length} atletas</span>
      </div>
      <input
        type="text"
        placeholder="Buscar atleta..."
        value={q}
        onChange={e => setQ(e.target.value)}
        className="w-full bg-white/5 rounded-xl px-4 py-3 text-sm text-white placeholder-white/20 outline-none focus:ring-1 focus:ring-[#00E87A]/40 transition-all"
        style={{ border: "1px solid rgba(255,255,255,0.07)" }}
      />
      <div className="flex flex-col gap-2">
        {filtered.map((p, i) => (
          <div
            key={p.id}
            className="flex items-center gap-4 p-4 rounded-2xl cursor-pointer active:scale-[0.98] transition-transform"
            style={{ background: "#141419", border: "1px solid rgba(255,255,255,0.06)" }}
            onClick={() => { handleNavigate(p.id) }}
          >
            <span className="text-xs text-white/20 font-bold w-4 text-center shrink-0 font-title">{i + 1}</span>
            <Av player={p} size="lg" />
            <div className="flex-1 min-w-0">
              <div className="flex items-center gap-2 mb-0.5">
                <span className="text-base font-black text-white truncate font-title">{p.nick}</span>
                <Pos pos={p.pos} />
              </div>
              <div className="text-[10px] text-white/30 mb-1.5">{p.name}</div>
              <div className="flex items-center gap-1">
                {p.lastResults.map((r, ri) => <Dot key={ri} r={r} />)}
              </div>
            </div>
            <div className="flex gap-4 shrink-0 text-center">
              <div>
                <div className="text-xl font-black leading-none font-title" style={{ color: "#FFB800" }}>{p.goals}</div>
                <div className="text-[8px] text-white/25 uppercase tracking-wider mt-0.5">gols</div>
              </div>
              <div>
                <div className="text-xl font-black leading-none font-title" style={{ color: "#00E87A" }}>{p.wins}</div>
                <div className="text-[8px] text-white/25 uppercase tracking-wider mt-0.5">vit</div>
              </div>
            </div>
            <ChevronRight className="w-4 h-4 text-white/15 shrink-0" />
          </div>
        ))}
      </div>
    </div>
  );
}