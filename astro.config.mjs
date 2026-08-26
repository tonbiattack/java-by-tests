import { defineConfig } from "astro/config";
// Design system: 証明の作業台 — GitHub Pages対応のコード中心静的サイト。
export default defineConfig({ site: "https://tonbiattack.github.io", base: process.env.GITHUB_ACTIONS ? "/java-by-tests" : "/", output: "static" });
