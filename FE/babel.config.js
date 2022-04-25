module.exports = {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b3671d9 ([#6] Chore: babel config에 `runtime: automatic' 추가)
  presets: [
    "@babel/preset-env",
    ["@babel/preset-react", { runtime: "automatic" }],
  ],
<<<<<<< HEAD
  plugins: [
    "@babel/plugin-transform-runtime",
    "babel-plugin-styled-components",
  ],
=======
  presets: ["@babel/preset-env", "@babel/preset-react"],
<<<<<<< HEAD
>>>>>>> ccf5e4b ([#6] Chore: CRA 없이 React 빌드 환경 구축)
=======
=======
>>>>>>> b3671d9 ([#6] Chore: babel config에 `runtime: automatic' 추가)
  plugins: ["@babel/plugin-transform-runtime"],
>>>>>>> 6a903a6 ([#13] Chore: babel transform-runtime-plugin 설치, 설정)
};
