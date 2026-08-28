import { Home, List, Plus, Trophy, Users } from "lucide-react";
import { useState, type CSSProperties } from "react";
import { NavLink, Outlet } from "react-router";

type Screen = "home" | "matches" | "rankings" | "players";

const nav = [
  { to: "/", Icon: Home, label: "Central" },
  { to: "/matches", Icon: List, label: "Partidas" },
  { to: "/rankings", Icon: Trophy, label: "Rankings" },
  { to: "/players", Icon: Users, label: "Jogadores" },
];

const App = () => {
  const [registerOpen, setRegisterOpen] = useState(false);

  return (
    <div className="min-h-screen bg-red-400">
      <div
        className="hidden md:flex flex-col fixed left-0 top-0 bottom-0 w-60 z-40"
        style={{ background: "#0e0e13", borderRight: "1px solid rgba(255,255,255,0.05)" }}
      >
        <div className="px-6 pt-8 pb-6">
          <div className="text-[9px] tracking-[0.22em] text-white/20 uppercase mb-1">
            ⚽ Temporada 2025
          </div>
          <div className="text-3xl font-black text-white font-title">
            RachaHub
          </div>
        </div>
        <nav className="flex flex-col gap-1 px-3 flex-1">
          {nav.map(({ to, Icon, label }) => (
            <NavLink
              key={to}
              to={to}
              className={({ isActive }) =>
                `flex items-center gap-3 px-4 py-3 rounded-xl text-sm transition-all ${
                  isActive
                    ? "bg-[#00E87A]/10 text-[#00E87A] font-bold"
                    : "text-white/35 hover:text-white/65 hover:bg-white/5"
                }`
              }
            >
              <Icon className="w-5 h-5 flex-shrink-0" />
              {label}
            </NavLink>
          ))}
        </nav>
        <div className="p-4 pb-6">
          <button
            onClick={() => setRegisterOpen(true)}
            className="w-full py-3.5 rounded-2xl font-title font-black text-sm text-black flex items-center justify-center gap-2 active:scale-95 transition-all"
            style={{ background: "#00E87A", boxShadow: "0 0 24px rgba(0,232,122,0.2)" }}
          >
            <Plus className="w-4 h-4" />
            Nova Partida
          </button>
        </div>
      </div>

      <main className="md:pl-60">
        <Outlet />
        <div
          className="md:hidden fixed bottom-0 left-0 right-0 z-40 flex items-stretch"
          style={{ background: "rgba(11,11,15,0.96)", backdropFilter: "blur(24px)", borderTop: "1px solid rgba(255,255,255,0.06)", paddingBottom: "env(safe-area-inset-bottom, 0px)" }}
        >
          {nav.map(({ to, Icon, label }) => (
            <NavLink
              key={to}
              to={to}
              className="relative flex-1 flex flex-col items-center gap-1 py-3 active:scale-90 transition-transform"
            >
              {({ isActive }) => (
                <>
                  <div
                    className={
                      isActive
                        ? "absolute top-0 left-1/2 -translate-x-1/2 w-6 h-0.5 bg-[#00E87A] rounded-full"
                        : ""
                    }
                  />
                  <Icon
                    className={`w-5 h-5 transition-colors ${
                      isActive ? "text-[#00E87A]" : "text-white/25"
                    }`}
                  />

                  <span
                    className={`text-[9px] font-bold transition-colors ${
                      isActive ? "text-[#00E87A]" : "text-white/20"
                    }`}
                  >
                    {label}
                  </span>
                </>
              )}
            </NavLink>
          ))}
      </div>
      </main>
    </div>
  );
}

export default App;