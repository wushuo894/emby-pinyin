import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'
import compression from 'vite-plugin-compression'

// https://vitejs.dev/config/
export default defineConfig({
    base: './',
    server: {
        proxy: {
            '/api': {
                target: 'http://127.0.0.1:9198',
                changeOrigin: true,
            }
        }
    },
    plugins: [
        vue(),
        AutoImport({
            imports: ['vue'],
            resolvers: [ElementPlusResolver()]
        }),
        Components({
            resolvers: [ElementPlusResolver({
                importStyle: 'css',
            })]
        }),
        compression({
            // 输出压缩日志
            verbose: true,
            // 是否禁用压缩
            disable: false,
            // 对超过10KB的文件进行压缩
            threshold: 10240,
            // 使用gzip压缩
            algorithm: 'gzip',
            // 压缩后文件的扩展名
            ext: '.gz'
        }),
    ],
    resolve: {
        alias: {
            '@': path.resolve(__dirname, './src/')
        }
    },
})
