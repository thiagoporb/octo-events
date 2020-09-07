//package com.example.octoevents.domain.repository
//
//import com.example.octoevents.domain.*
//import org.jetbrains.exposed.dao.IntIdTable
//import org.jetbrains.exposed.dao.LongIdTable
//import org.jetbrains.exposed.sql.*
//import org.jetbrains.exposed.sql.transactions.transaction
//import javax.sql.DataSource
//
//internal object Events : LongIdTable("event") {
//
//    var ref = varchar("ref", 255).nullable()
//    var before = varchar("before", 255).nullable()
//    var after = varchar("after", 255).nullable()
//    val repositoryId = long("repository_id").references(Repositorys.id).nullable()
//    val pusherId = (varchar("pusher_id", 255) references Pushers.email).nullable()
//    val senderId = long("sender_id").references(Senders.id).nullable()
//    var created = bool("created").nullable()
//    var deleted = bool("deleted").nullable()
//    var forced = bool("forced").nullable()
//    var baseRef = varchar("base_ref", 255).nullable()
//    var compare = varchar("compare", 255).nullable()
//
//    //var commits by Commit via RepositoryCommit
//    //var commits: MutableList<Commit>? = mutableListOf()
//    var headCommitId = varchar("head_commit_id", 255).references(HeadCommits.id).nullable()
//}
//
//internal object Repositorys : Table("repository") {
//    var id = long("id").uniqueIndex().primaryKey()
//    var nodeId = varchar("node_id", 255).nullable()
//    var name = varchar("name", 255).nullable()
//    var fullName = varchar("full_name", 255).nullable()
//    var _private = bool("private").nullable()
//    var ownerId = long("owner_id").references(Owners.id).nullable()
//    var htmlUrl = varchar("html_url", 255).nullable()
//    var description = varchar("description", 255).nullable()
//    var fork = bool("fork").nullable()
//    var url = varchar("url", 255).nullable()
//    var forksUrl = varchar("forks_url", 255).nullable()
//    var keysUrl = varchar("keys_url", 255).nullable()
//    var collaboratorsUrl = varchar("collaborators_url", 255).nullable()
//    var teamsUrl = varchar("teams_url", 255).nullable()
//    var hooksUrl = varchar("hooks_url", 255).nullable()
//    var issueEventsUrl = varchar("issueEvents_url", 255).nullable()
//    var eventsUrl = varchar("events_url", 255).nullable()
//    var assigneesUrl = varchar("assignees_url", 255).nullable()
//    var branchesUrl = varchar("branches_url", 255).nullable()
//    var tagsUrl = varchar("tags_url", 255).nullable()
//    var blobsUrl = varchar("blobs_url", 255).nullable()
//    var gitTagsUrl = varchar("git_tags_url", 255).nullable()
//    var gitRefsUrl = varchar("git_refs_url", 255).nullable()
//    var treesUrl = varchar("trees_url", 255).nullable()
//    var statusesUrl = varchar("statuses_url", 255).nullable()
//    var languagesUrl = varchar("languages_url", 255).nullable()
//    var stargazersUrl = varchar("stargazers_url", 255).nullable()
//    var contributorsUrl = varchar("contributors_url", 255).nullable()
//    var subscribersUrl = varchar("subscribers_url", 255).nullable()
//    var subscriptionUrl = varchar("subscription_url", 255).nullable()
//    var commitsUrl = varchar("commits_url", 255).nullable()
//    var gitCommitsUrl = varchar("git_commits_url", 255).nullable()
//    var commentsUrl = varchar("comments_url", 255).nullable()
//    var issueCommentUrl = varchar("issue_comment_url", 255).nullable()
//    var contentsUrl = varchar("contents_url", 255).nullable()
//    var compareUrl = varchar("compare_url", 255).nullable()
//    var mergesUrl = varchar("merges_url", 255).nullable()
//    var archiveUrl = varchar("archive_url", 255).nullable()
//    var downloadsUrl = varchar("downloads_url", 255).nullable()
//    var issuesUrl = varchar("issues_url", 255).nullable()
//    var pullsUrl = varchar("pulls_url", 255).nullable()
//    var milestonesUrl = varchar("milestones_url", 255).nullable()
//    var notificationsUrl = varchar("notifications_url", 255).nullable()
//    var labelsUrl = varchar("labels_url", 255).nullable()
//    var releasesUrl = varchar("releases_url", 255).nullable()
//    var deploymentsUrl = varchar("deployments_url", 255).nullable()
//    var createdAt = integer("created_at").nullable()
//    var updatedAt = varchar("updated_at", 255).nullable()
//    var pushedAt = integer("pushed_at").nullable()
//    var gitUrl = varchar("git_url", 255).nullable()
//    var sshUrl = varchar("ssh_url", 255).nullable()
//    var cloneUrl = varchar("clone_url", 255).nullable()
//    var svnUrl = varchar("svn_url", 255).nullable()
//    var homepage = varchar("homepage", 255).nullable()
//    var size = integer("size").nullable()
//    var stargazersCount = integer("stargazers_count").nullable()
//    var watchersCount = integer("watchers_count").nullable()
//    var language = varchar("language", 255).nullable()
//    var hasIssues = bool("has_issues").nullable()
//    var hasProjects = bool("has_projects").nullable()
//    var hasDownloads = bool("has_downloads").nullable()
//    var hasWiki = bool("has_wiki").nullable()
//    var hasPages = bool("has_pages").nullable()
//    var forksCount = integer("forks_count").nullable()
//    var mirrorUrl = varchar("mirror_url", 255).nullable()
//    var archived = bool("archived").nullable()
//    var disabled = bool("disabled").nullable()
//    var openIssuesCount = integer("open_issues_count").nullable()
//    var licenseId = integer("license_id").references(Licenses.id).nullable()
//    var forks = integer("forks").nullable()
//    var openIssues = integer("openIssues").nullable()
//    var watchers = integer("watchers").nullable()
//    var defaultBranch = varchar("default_branch", 255).nullable()
//    var stargazers = integer("stargazers").nullable()
//    var masterBranch = varchar("master_branch", 255).nullable()
//}
//
//internal object Owners : Table("owner") {
//    var id = long("id").uniqueIndex().primaryKey(0)
//    var name = varchar("name", 255).nullable()
//    var email = varchar("email", 255).nullable()
//    var login = varchar("login", 255).nullable()
//    var nodeId = varchar("node_id", 255).nullable()
//    var avatarUrl = varchar("avatar_url", 255).nullable()
//    var gravatarId = varchar("gravatar_id", 255).nullable()
//    var url = varchar("url", 255).nullable()
//    var htmlUrl = varchar("html_url", 255).nullable()
//    var followersUrl = varchar("followers_url", 255).nullable()
//    var followingUrl = varchar("following_url", 255).nullable()
//    var gistsUrl = varchar("gists_url", 255).nullable()
//    var starredUrl = varchar("starred_url", 255).nullable()
//    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
//    var organizationsUrl = varchar("organizations_url", 255).nullable()
//    var reposUrl = varchar("repos_url", 255).nullable()
//    var eventsUrl = varchar("events_url", 255).nullable()
//    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
//    var type = varchar("type", 255).nullable()
//    var siteAdmin = bool("site_admin").nullable()
//}
//
//internal object Licenses : IntIdTable("license") {
//    var key = varchar("key", 255).nullable()
//    var name = varchar("name", 255).nullable()
//    var spdxId = varchar("spdx_id", 255).nullable()
//    var url = varchar("url", 255).nullable()
//    var nodeId = varchar("node_id", 255).nullable()
//}
//
//internal object Pushers : Table("pusher") {
//    var name = varchar("name", 255).nullable()
//    var email = varchar("email", 255).uniqueIndex().primaryKey()
//}
//
//internal object Senders : Table("sender") {
//    var id = long("id").uniqueIndex().primaryKey()
//    var login = varchar("login", 255).nullable()
//    var nodeId = varchar("node_id", 255).nullable()
//    var avatarUrl = varchar("avatar_url", 255).nullable()
//    var gravatarId = varchar("gravatar_id", 255).nullable()
//    var url = varchar("url", 255).nullable()
//    var htmlUrl = varchar("html_url", 255).nullable()
//    var followersUrl = varchar("followers_url", 255).nullable()
//    var followingUrl = varchar("following_url", 255).nullable()
//    var gistsUrl = varchar("gists_url", 255).nullable()
//    var starredUrl = varchar("starred_url", 255).nullable()
//    var subscriptionsUrl = varchar("subscriptions_url", 255).nullable()
//    var organizationsUrl = varchar("organizations_url", 255).nullable()
//    var reposUrl = varchar("repos_url", 255).nullable()
//    var eventsUrl = varchar("events_url", 255).nullable()
//    var receivedEventsUrl = varchar("received_events_url", 255).nullable()
//    var type = varchar("type", 255).nullable()
//    var siteAdmin = bool("site_admin").nullable()
//}
//
//internal object Commits : Table("commit") {
//    var id = varchar("id", 255).uniqueIndex().primaryKey()
//    var treeId = varchar("tree_id", 255).nullable()
//    var distinct = bool("distinct").nullable()
//    var message = varchar("message", 255).nullable()
//    var timestamp = varchar("timestamp", 255).nullable()
//    var url = varchar("url", 255).nullable()
//    var authorId = (varchar("author_id", 255) references Authors.username).nullable()
//    var committerId = (varchar("committer_id", 255) references Committers.username).nullable()
//    var added = varchar("added", 255).nullable()
//    var removed = varchar("removed", 255).nullable()
//    var modified = varchar("modified", 255).nullable()
//}
//
//internal object RepositoryCommit : Table("repository_commit") {
//    val repositoryId = long("repository_id").primaryKey(0)
//    val commitId = varchar("commit_id", 255).primaryKey(1)
//}
//
//internal object Authors : Table("author") {
//    var name = varchar("name", 255).nullable()
//    var email = varchar("email", 255).nullable()
//    var username = varchar("username", 255).uniqueIndex().primaryKey()
//}
//
//internal object Committers : Table("committer") {
//    var name = varchar("name", 255).nullable()
//    var email = varchar("email", 255).nullable()
//    var username = varchar("username", 255).uniqueIndex().primaryKey()
//}
//
//internal object HeadCommits : Table("head_commit") {
//    var id = varchar("id", 255).uniqueIndex().primaryKey(0)
//    var treeId = varchar("tree_id", 255).nullable()
//    var distinct = bool("distinct").nullable()
//    var message = varchar("message", 255).nullable()
//    var timestamp = varchar("timestamp", 255).nullable()
//    var url = varchar("url", 255).nullable()
//    var authorId = varchar("author_id", 255).references(Authors.username).nullable()
//    var committerId = varchar("committer_id", 255).references(Committers.username).nullable()
//    var added = varchar("added", 255).nullable()
//    var removed = varchar("removed", 255).nullable()
//    var modified = varchar("modified", 255).nullable()
//}
//
//fun toDomain(row: ResultRow): IssuesEvent {
//    return IssuesEvent(
//        id = row[Events.id].value,
//        ref = row[Events.ref],
//        before = row[Events.before],
//        after = row[Events.after],
//        created = row[Events.created],
//        deleted = row[Events.deleted],
//        forced = row[Events.forced],
//        baseRef = row[Events.baseRef],
//        compare = row[Events.compare],
//        pusher = Pusher(row[Pushers.name], row[Pushers.email]),
//        sender = getSender(row),
//        repository = getRepository(row),
//        headCommit = getHeadCommit(row)
//    )
//}
//
//private fun getSender(row: ResultRow): Sender {
//    return Sender(
//        id = row[Senders.id],
//        url = row[Senders.url],
//        avatarUrl = row[Senders.avatarUrl],
//        eventsUrl = row[Senders.eventsUrl],
//        followersUrl = row[Senders.followersUrl],
//        followingUrl = row[Senders.followingUrl],
//        gistsUrl = row[Senders.gistsUrl],
//        gravatarId = row[Senders.gravatarId],
//        htmlUrl = row[Senders.htmlUrl],
//        login = row[Senders.login],
//        nodeId = row[Senders.nodeId],
//        organizationsUrl = row[Senders.organizationsUrl],
//        receivedEventsUrl = row[Senders.receivedEventsUrl],
//        reposUrl = row[Senders.reposUrl],
//        siteAdmin = row[Senders.siteAdmin],
//        starredUrl = row[Senders.starredUrl],
//        subscriptionsUrl = row[Senders.subscriptionsUrl],
//        type = row[Senders.type],
//    )
//}
//
//private fun getRepository(row: ResultRow): Repository {
//    return Repository(
//        id = row[Repositorys.id],
//        nodeId = row[Repositorys.nodeId],
//        name = row[Repositorys.name],
//        fullName = row[Repositorys.fullName],
//        _private = row[Repositorys._private],
//        owner = Owner(
//            name = row[Owners.name],
//            email = row[Owners.email],
//            login = row[Owners.login],
//            id = row[Owners.id],
//            nodeId = row[Owners.nodeId],
//            avatarUrl = row[Owners.avatarUrl],
//            gravatarId = row[Owners.gravatarId],
//            url = row[Owners.url],
//            htmlUrl = row[Owners.htmlUrl],
//            followersUrl = row[Owners.followersUrl],
//            followingUrl = row[Owners.followingUrl],
//            gistsUrl = row[Owners.gistsUrl],
//            starredUrl = row[Owners.starredUrl],
//            subscriptionsUrl = row[Owners.subscriptionsUrl],
//            organizationsUrl = row[Owners.organizationsUrl],
//            reposUrl = row[Owners.reposUrl],
//            eventsUrl = row[Owners.eventsUrl],
//            receivedEventsUrl = row[Owners.receivedEventsUrl],
//            type = row[Owners.type],
//            siteAdmin = row[Owners.siteAdmin]
//        ),
//        htmlUrl = row[Repositorys.htmlUrl],
//        description = row[Repositorys.description],
//        fork = row[Repositorys.fork],
//        url = row[Repositorys.url],
//        forksUrl = row[Repositorys.forksUrl],
//        keysUrl = row[Repositorys.keysUrl],
//        collaboratorsUrl = row[Repositorys.collaboratorsUrl],
//        teamsUrl = row[Repositorys.teamsUrl],
//        hooksUrl = row[Repositorys.hooksUrl],
//        issueEventsUrl = row[Repositorys.issueEventsUrl],
//        eventsUrl = row[Repositorys.eventsUrl],
//        assigneesUrl = row[Repositorys.assigneesUrl],
//        branchesUrl = row[Repositorys.branchesUrl],
//        tagsUrl = row[Repositorys.tagsUrl],
//        blobsUrl = row[Repositorys.blobsUrl],
//        gitTagsUrl = row[Repositorys.gitTagsUrl],
//        gitRefsUrl = row[Repositorys.gitRefsUrl],
//        treesUrl = row[Repositorys.treesUrl],
//        statusesUrl = row[Repositorys.statusesUrl],
//        languagesUrl = row[Repositorys.languagesUrl],
//        stargazersUrl = row[Repositorys.stargazersUrl],
//        contributorsUrl = row[Repositorys.contributorsUrl],
//        subscribersUrl = row[Repositorys.subscribersUrl],
//        subscriptionUrl = row[Repositorys.subscriptionUrl],
//        commitsUrl = row[Repositorys.commitsUrl],
//        gitCommitsUrl = row[Repositorys.gitCommitsUrl],
//        commentsUrl = row[Repositorys.commentsUrl],
//        issueCommentUrl = row[Repositorys.issueCommentUrl],
//        contentsUrl = row[Repositorys.contentsUrl],
//        compareUrl = row[Repositorys.compareUrl],
//        mergesUrl = row[Repositorys.mergesUrl],
//        archiveUrl = row[Repositorys.archiveUrl],
//        downloadsUrl = row[Repositorys.downloadsUrl],
//        issuesUrl = row[Repositorys.issuesUrl],
//        pullsUrl = row[Repositorys.pullsUrl],
//        milestonesUrl = row[Repositorys.milestonesUrl],
//        notificationsUrl = row[Repositorys.notificationsUrl],
//        labelsUrl = row[Repositorys.labelsUrl],
//        releasesUrl = row[Repositorys.releasesUrl],
//        deploymentsUrl = row[Repositorys.deploymentsUrl],
//        createdAt = row[Repositorys.createdAt],
//        updatedAt = row[Repositorys.updatedAt],
//        pushedAt = row[Repositorys.pushedAt],
//        gitUrl = row[Repositorys.gitUrl],
//        sshUrl = row[Repositorys.sshUrl],
//        cloneUrl = row[Repositorys.cloneUrl],
//        svnUrl = row[Repositorys.svnUrl],
//        homepage = row[Repositorys.homepage],
//        size = row[Repositorys.size],
//        stargazersCount = row[Repositorys.stargazersCount],
//        watchersCount = row[Repositorys.watchersCount],
//        language = row[Repositorys.language],
//        hasIssues = row[Repositorys.hasIssues],
//        hasProjects = row[Repositorys.hasProjects],
//        hasDownloads = row[Repositorys.hasDownloads],
//        hasWiki = row[Repositorys.hasWiki],
//        hasPages = row[Repositorys.hasPages],
//        forksCount = row[Repositorys.forksCount],
//        mirrorUrl = row[Repositorys.mirrorUrl],
//        archived = row[Repositorys.archived],
//        disabled = row[Repositorys.disabled],
//        openIssuesCount = row[Repositorys.openIssuesCount],
//        license = License(
//            key = row[Licenses.key],
//            name = row[Licenses.name],
//            spdxId = row[Licenses.spdxId],
//            url = row[Licenses.url],
//            nodeId = row[Licenses.nodeId]
//        ),
//        forks = row[Repositorys.forks],
//        openIssues = row[Repositorys.openIssues],
//        watchers = row[Repositorys.watchers],
//        defaultBranch = row[Repositorys.defaultBranch],
//        stargazers = row[Repositorys.stargazers],
//        masterBranch = row[Repositorys.masterBranch]
//    )
//}
//
//private fun getHeadCommit(row: ResultRow): HeadCommit {
//    return HeadCommit(
//        id = row[HeadCommits.id],
//        treeId = row[HeadCommits.treeId],
//        distinct = row[HeadCommits.distinct],
//        message = row[HeadCommits.message],
//        timestamp = row[HeadCommits.timestamp],
//        url = row[HeadCommits.url],
//        author = getAuthor(row),
//        committer = getCommitter(row),
//        added = row[HeadCommits.added]?.split(",")?.toMutableList(),
//        removed = row[HeadCommits.removed]?.split(",")?.toMutableList(),
//        modified = row[HeadCommits.modified]?.split(",")?.toMutableList()
//    )
//}
//
//private fun getAuthor(row: ResultRow): Author {
//    return Author(
//        name = row[Authors.name],
//        email = row[Authors.email],
//        username = row[Authors.username]
//    )
//}
//
//private fun getCommitter(row: ResultRow): Committer {
//    return Committer(
//        name = row[Committers.name],
//        email = row[Committers.email],
//        username = row[Committers.username]
//    )
//}
//
//private fun getCommit(row: ResultRow): Commit {
//    return Commit(
//        id = row[Commits.id],
//        url = row[Commits.url],
//        distinct = row[Commits.distinct],
//        message = row[Commits.message],
//        timestamp = row[Commits.timestamp],
//        treeId = row[Commits.treeId],
//        author = getAuthor(row),
//        committer = getCommitter(row),
//        added = row[Commits.added]?.split(",")?.toMutableList(),
//        modified = row[Commits.modified]?.split(",")?.toMutableList(),
//        removed = row[Commits.removed]?.split(",")?.toMutableList()
//    )
//}
//
//class IssueEventRepository(private val dataSource: DataSource) {
//
//    init {
//        transaction(Database.connect(dataSource)) {
//            addLogger(StdOutSqlLogger)
//            SchemaUtils.create(Events)
//            SchemaUtils.create(Commits)
//            SchemaUtils.create(RepositoryCommit)
//        }
//    }
//
//    /**
//     * Cria o evento
//     */
//    fun create(issuesEvent: IssuesEvent) {
//        return transaction(Database.connect(dataSource)) {
//            addLogger(StdOutSqlLogger)
//
//            // Event
//            insertEvent(issuesEvent)
//
//            insertCommits(issuesEvent)
//
//        }
//    }
//
//    /**
//     * Retorna o evento por id
//     */
//    fun findById(id: Long): IssuesEvent? {
//        return transaction(Database.connect(dataSource)) {
//            addLogger(StdOutSqlLogger)
//            Events
//                .join(Pushers, JoinType.INNER, additionalConstraint = { Events.pusherId eq Pushers.email })
//                .join(Senders, JoinType.INNER, additionalConstraint = { Events.senderId eq Senders.id })
//                .join(
//                    Repositorys,
//                    JoinType.INNER,
//                    additionalConstraint = { Events.repositoryId eq Repositorys.id })
//                .join(Owners, JoinType.INNER, additionalConstraint = { Repositorys.ownerId eq Owners.id })
//                .join(
//                    HeadCommits,
//                    JoinType.INNER,
//                    additionalConstraint = { Events.headCommitId eq HeadCommits.id })
//                .join(Authors, JoinType.INNER, additionalConstraint = { HeadCommits.authorId eq Authors.username })
//                .join(
//                    Committers,
//                    JoinType.INNER,
//                    additionalConstraint = { HeadCommits.committerId eq Committers.username })
//                .join(Licenses, JoinType.INNER, additionalConstraint = { Repositorys.licenseId eq Licenses.id })
//                .select { Events.id eq id }
//                .map { row ->
//                    toDomain(row).copy(
//                        commits = Commits
//                            .join(
//                                RepositoryCommit,
//                                JoinType.INNER,
//                                additionalConstraint = { Commits.id eq RepositoryCommit.commitId })
//                            .join(
//                                Authors,
//                                JoinType.INNER,
//                                additionalConstraint = { Commits.authorId eq Authors.username })
//                            .join(
//                                Committers,
//                                JoinType.INNER,
//                                additionalConstraint = { Commits.committerId eq Committers.username })
//                            .select { RepositoryCommit.repositoryId eq row[Repositorys.id] }
//                            .map { rowEv -> getCommit(rowEv) }
//                            .toMutableList()
//                    )
//                }
//                .firstOrNull()
//        }
//    }
//
//    private fun insertEvent(issuesEvent: IssuesEvent) {
//        Events.insertAndGetId { row ->
//            row[ref] = issuesEvent.ref
//            row[before] = issuesEvent.before
//            row[after] = issuesEvent.after
//            row[created] = issuesEvent.created
//            row[deleted] = issuesEvent.deleted
//            row[forced] = issuesEvent.forced
//            row[baseRef] = issuesEvent.baseRef
//            row[compare] = issuesEvent.compare
//            row[repositoryId] = issuesEvent.repository?.let { insertRepository(it) }
//            row[pusherId] = issuesEvent.pusher?.let { insertPusher(it) }
//            row[senderId] = issuesEvent.sender?.let { insertSender(it) }
//            row[headCommitId] = issuesEvent.headCommit?.let { insertHeadCommit(it) }
//        }.value
//    }
//
//    private fun insertRepository(repository: Repository): Long {
//        return Repositorys.insert { row ->
//            row[id] = repository.id
//            row[nodeId] = repository.nodeId
//            row[name] = repository.name
//            row[fullName] = repository.fullName
//            row[_private] = repository._private
//            row[ownerId] = repository.owner?.let { insertOwner(it) }
//            row[htmlUrl] = repository.htmlUrl
//            row[description] = repository.description
//            row[fork] = repository.fork
//            row[url] = repository.url
//            row[forksUrl] = repository.forksUrl
//            row[keysUrl] = repository.keysUrl
//            row[collaboratorsUrl] = repository.collaboratorsUrl
//            row[teamsUrl] = repository.teamsUrl
//            row[hooksUrl] = repository.hooksUrl
//            row[issueEventsUrl] = repository.issueEventsUrl
//            row[eventsUrl] = repository.eventsUrl
//            row[assigneesUrl] = repository.assigneesUrl
//            row[branchesUrl] = repository.branchesUrl
//            row[tagsUrl] = repository.tagsUrl
//            row[blobsUrl] = repository.blobsUrl
//            row[gitTagsUrl] = repository.gitTagsUrl
//            row[gitRefsUrl] = repository.gitRefsUrl
//            row[treesUrl] = repository.treesUrl
//            row[statusesUrl] = repository.statusesUrl
//            row[languagesUrl] = repository.languagesUrl
//            row[stargazersUrl] = repository.stargazersUrl
//            row[contributorsUrl] = repository.contributorsUrl
//            row[subscribersUrl] = repository.subscribersUrl
//            row[subscriptionUrl] = repository.subscriptionUrl
//            row[commitsUrl] = repository.commentsUrl
//            row[gitCommitsUrl] = repository.gitCommitsUrl
//            row[commentsUrl] = repository.commentsUrl
//            row[issueCommentUrl] = repository.issueCommentUrl
//            row[contentsUrl] = repository.contentsUrl
//            row[compareUrl] = repository.compareUrl
//            row[mergesUrl] = repository.mergesUrl
//            row[archiveUrl] = repository.archiveUrl
//            row[downloadsUrl] = repository.downloadsUrl
//            row[issuesUrl] = repository.issuesUrl
//            row[pullsUrl] = repository.pullsUrl
//            row[milestonesUrl] = repository.milestonesUrl
//            row[notificationsUrl] = repository.notificationsUrl
//            row[labelsUrl] = repository.labelsUrl
//            row[releasesUrl] = repository.releasesUrl
//            row[deploymentsUrl] = repository.deploymentsUrl
//            row[createdAt] = repository.createdAt
//            row[updatedAt] = repository.updatedAt
//            row[pushedAt] = repository.pushedAt
//            row[gitUrl] = repository.gitUrl
//            row[sshUrl] = repository.sshUrl
//            row[cloneUrl] = repository.cloneUrl
//            row[svnUrl] = repository.svnUrl
//            row[homepage] = repository.homepage
//            row[size] = repository.size
//            row[stargazersCount] = repository.stargazersCount
//            row[watchersCount] = repository.watchersCount
//            row[language] = repository.language
//            row[hasIssues] = repository.hasIssues
//            row[hasProjects] = repository.hasProjects
//            row[hasDownloads] = repository.hasDownloads
//            row[hasWiki] = repository.hasWiki
//            row[hasPages] = repository.hasPages
//            row[forksCount] = repository.forksCount
//            row[mirrorUrl] = repository.mirrorUrl
//            row[archived] = repository.archived
//            row[disabled] = repository.disabled
//            row[openIssuesCount] = repository.openIssuesCount
//            row[licenseId] = repository.license?.let { insertLicense(it) }
//            row[forks] = repository.forks
//            row[openIssues] = repository.openIssues
//            row[watchers] = repository.watchers
//            row[defaultBranch] = repository.defaultBranch
//            row[stargazers] = repository.stargazers
//            row[masterBranch] = repository.masterBranch
//        } get Repositorys.id
//    }
//
//    private fun insertOwner(owner: Owner): Long {
//        return Owners.insert { row ->
//            row[id] = owner.id
//            row[name] = owner.name
//            row[email] = owner.email
//            row[login] = owner.login
//            row[nodeId] = owner.nodeId
//            row[avatarUrl] = owner.avatarUrl
//            row[gravatarId] = owner.gravatarId
//            row[url] = owner.url
//            row[htmlUrl] = owner.htmlUrl
//            row[followersUrl] = owner.followersUrl
//            row[followingUrl] = owner.followingUrl
//            row[gistsUrl] = owner.gistsUrl
//            row[starredUrl] = owner.starredUrl
//            row[subscriptionsUrl] = owner.subscriptionsUrl
//            row[organizationsUrl] = owner.organizationsUrl
//            row[reposUrl] = owner.reposUrl
//            row[eventsUrl] = owner.eventsUrl
//            row[receivedEventsUrl] = owner.receivedEventsUrl
//            row[type] = owner.type
//            row[siteAdmin] = owner.siteAdmin
//        } get Owners.id
//
//    }
//
//    private fun insertLicense(license: License): Int {
//        return Licenses.insertAndGetId { row ->
//            row[key] = license.key
//            row[name] = license.name
//            row[spdxId] = license.spdxId
//            row[url] = license.url
//            row[nodeId] = license.nodeId
//        }.value
//    }
//
//    private fun insertPusher(pusher: Pusher): String {
//        return Pushers.insert { row ->
//            row[name] = pusher.name
//            row[email] = pusher.email!!
//        } get Pushers.email
//    }
//
//    private fun insertSender(sender: Sender): Long {
//        return Senders.insert { row ->
//            row[id] = sender.id
//            row[login] = sender.login
//            row[nodeId] = sender.nodeId
//            row[avatarUrl] = sender.avatarUrl
//            row[gravatarId] = sender.gravatarId
//            row[url] = sender.url
//            row[htmlUrl] = sender.htmlUrl
//            row[followersUrl] = sender.followersUrl
//            row[followingUrl] = sender.followingUrl
//            row[gistsUrl] = sender.gistsUrl
//            row[starredUrl] = sender.starredUrl
//            row[subscriptionsUrl] = sender.subscriptionsUrl
//            row[organizationsUrl] = sender.organizationsUrl
//            row[reposUrl] = sender.reposUrl
//            row[eventsUrl] = sender.eventsUrl
//            row[receivedEventsUrl] = sender.receivedEventsUrl
//            row[type] = sender.type
//            row[siteAdmin] = sender.siteAdmin
//        } get Senders.id
//    }
//
//    private fun insertHeadCommit(headCommit: HeadCommit): String {
//        return HeadCommits.insert { row ->
//            row[id] = headCommit.id!!
//            row[treeId] = headCommit.treeId
//            row[distinct] = headCommit.distinct
//            row[message] = headCommit.message
//            row[timestamp] = headCommit.timestamp
//            row[authorId] = headCommit.author?.let { insertAuthor(it) }
//            row[committerId] = headCommit.committer?.let { insertCommitter(it) }
//            row[added] = headCommit.added?.joinToString()
//            row[removed] = headCommit.removed?.joinToString()
//            row[modified] = headCommit.modified?.joinToString()
//            row[url] = headCommit.url
//        } get HeadCommits.id
//    }
//
//    private fun insertAuthor(author: Author): String {
//        return Authors.insertIgnore { row ->
//            row[name] = author.name
//            row[email] = author.email
//            row[username] = author.username
//        } get Authors.username
//    }
//
//    private fun insertCommitter(committer: Committer): String {
//        return Committers.insertIgnore { row ->
//            row[name] = committer.name
//            row[email] = committer.email
//            row[username] = committer.username
//        } get Committers.username
//    }
//
//    private fun insertCommit(commit: Commit): String {
//        return Commits.insert { row ->
//            row[id] = commit.id
//            row[treeId] = commit.treeId
//            row[distinct] = commit.distinct
//            row[message] = commit.message
//            row[timestamp] = commit.timestamp
//            row[url] = commit.url
//            row[authorId] = commit.author?.username
//            row[committerId] = commit.committer?.username
//            row[added] = commit.added?.joinToString()
//            row[modified] = commit.modified?.joinToString()
//            row[removed] = commit.removed?.joinToString()
//        } get Commits.id
//    }
//
//    private fun insertCommits(event: IssuesEvent) {
//        event.commits?.forEach {
//            it.author?.let { author -> insertAuthor(author) }
//        }
//
//        event.commits?.forEach {
//            it.committer?.let { committer -> insertCommitter(committer) }
//        }
//
//        event.commits?.map { commit ->
//            Commits.slice(Commits.id)
//                .select { Commits.id.eq(commit.id) }
//                .map { row -> row[Commits.id] }
//                .firstOrNull() ?: insertCommit(commit)
//        }.also {
//            if (!it.isNullOrEmpty()) {
//                RepositoryCommit.batchInsert(it.asIterable()) { commitId ->
//                    this[RepositoryCommit.commitId] = commitId
//                    this[RepositoryCommit.repositoryId] = event.repository?.id!!
//                }
//            }
//        }
//    }
//
//}
//
