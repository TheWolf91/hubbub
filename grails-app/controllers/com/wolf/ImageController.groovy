package com.wolf

class PhotoUploadCommand {
    byte[] photo
    String loginId
}

class ImageController {

    def upload(PhotoUploadCommand puc) {
        def user = User.findByLoginId(puc.loginId)
        user.profile.photo = puc.photo
        user.save(flush: true) //flush: true necessario per aggiornare all'istante il DB con la foto
        redirect controller: "user", action: "profile", id: puc.loginId
    }

    def form() {
        [ userList: User.list() ]
    }

    def rawUpload() {
// a Spring MultipartFile
        def mpf = request.getFile('photo')
        if (!mpf?.empty && mpf.size < 1024*200) {
            mpf.transferTo(new File("/hubbub/images/${params.loginId}/mugshot.gif"))
        }
    }

    def renderImage(String id) {
        def user = User.findByLoginId(id)
        if (user?.profile?.photo) {
            response.setContentLength(user.profile.photo.size())
            response.outputStream.write(user.profile.photo)
        } else {
            response.sendError(404)
        }
    }
}
