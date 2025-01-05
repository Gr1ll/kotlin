import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  lang: 'de-CH  ',
  title: "Room Manager",
  description: "Room Manager",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      { text: 'API Docs', link: '/kdoc/index.html', target:'_self' },
    ],
    sidebar: [
      {
        text: 'Guide',
        items: [
          {text: 'Einfuerung', link: '/guide/index.md' },
          { text: 'Gradle Verstehen',
            items: [
              {text: 'Einfuerung', link: '/guide/gradle/index.md'},
              {text: 'Abhangigkeiten mit TOML', link: '/guide/gradle/toml.md'}
            ]},
          { text: 'API Doku Verstehen',
            items: [
              { text: 'Einfuerung', link: '/guide/api/index.md'} ,
              { text: 'Dokka Konfiguration', link: 'guide/api/dokka.md'}
            ]
          },
          {text: 'Kotlin', items:[
            {text: 'Einfuerung', link: '/guide/kotlin/index.md'},
            {text: 'Referenzen' , link:'/guide/kotlin/refs.md'},
          ]  },
        ]
      },
    ] },
} )
