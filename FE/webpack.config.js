const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");

module.exports = {
  mode: "development",
  devtool: "eval",
  resolve: {
<<<<<<< HEAD
<<<<<<< HEAD
    alias: { "@": path.resolve(__dirname, "src") },
=======
>>>>>>> ccf5e4b ([#6] Chore: CRA 없이 React 빌드 환경 구축)
=======
    alias: { "@src": path.resolve(__dirname, "src") },
>>>>>>> c7c1f6e ([#6] Chore: webpack.config.js에 절대경로 alias 설정)
    extensions: [".js", ".jsx", ".css", ".scss"],
  },
  entry: path.join(__dirname, "src", "index.js"),
  output: {
    filename: "[name].js",
<<<<<<< HEAD
    path: path.resolve(__dirname, "build"),
=======
    path: path.resolve(__dirname, "dist"),
>>>>>>> ccf5e4b ([#6] Chore: CRA 없이 React 빌드 환경 구축)
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        loader: "babel-loader",
      },
      {
        test: /\.scss$/,
        use: ["style-loader", "css-loader", "sass-loader"],
        exclude: /node_modules/,
      },
      {
        test: /\.(png|svg|jpe?g|gif)/,
        type: "asset/inline",
      },
    ],
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin({
      template: path.join(__dirname, "public", "index.html"),
    }),
  ],
  devServer: {
    host: "localhost",
    port: 3000,
    open: true,
    historyApiFallback: true,
    hot: true,
  },
};
