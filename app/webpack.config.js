var path = require('path');

module.exports = {
  entry: '../loyalty-hub/src/main.js',
  devtool: 'sourcemaps',
  cache: true,
  mode: 'development',
  output: {
    path: path.join(__dirname, 'target', 'classes', 'static', 'js'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.css$/,
        use: [
          'style-loader',
          'css-loader'
        ]
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  }
};
