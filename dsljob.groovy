job('hijodedslgit'){
  description('Job DSL de ejemplo para Jenkins')
  scm{
    git('https://github.com/jacfpentester/jenkinsscript.git', 'master'){
      node ->
        node / gitConfigName('jacfpentester')
        node / gitConfigEmail('jacfpentester@gmail.com')
    }
  }
  parameters{
    choiceParam('Colores',['Rojo', 'Verde', 'Amarillo (default)'] )
  }
  triggers {
    cron('H/1 * * * *')
    githubPush()
  }
  steps {
    shell("bash prueba.sh")
  }
  publishers {
    mailer('jacfpentester@gmail.com',true,true)
  }
}
