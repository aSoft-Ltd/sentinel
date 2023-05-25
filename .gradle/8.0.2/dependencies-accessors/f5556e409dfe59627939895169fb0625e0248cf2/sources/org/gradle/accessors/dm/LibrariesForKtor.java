package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `ktor` extension.
*/
@NonNullApi
public class LibrariesForKtor extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ClientLibraryAccessors laccForClientLibraryAccessors = new ClientLibraryAccessors(owner);
    private final ServerLibraryAccessors laccForServerLibraryAccessors = new ServerLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForKtor(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for http (io.ktor:ktor-http)
         * This dependency was declared in catalog ktor.toml
         */
        public Provider<MinimalExternalModuleDependency> getHttp() { return create("http"); }

    /**
     * Returns the group of libraries at client
     */
    public ClientLibraryAccessors getClient() { return laccForClientLibraryAccessors; }

    /**
     * Returns the group of libraries at server
     */
    public ServerLibraryAccessors getServer() { return laccForServerLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class ClientLibraryAccessors extends SubDependencyFactory {

        public ClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for cio (io.ktor:ktor-client-cio)
             * This dependency was declared in catalog ktor.toml
             */
            public Provider<MinimalExternalModuleDependency> getCio() { return create("client.cio"); }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-client-core)
             * This dependency was declared in catalog ktor.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("client.core"); }

            /**
             * Creates a dependency provider for js (io.ktor:ktor-client-js)
             * This dependency was declared in catalog ktor.toml
             */
            public Provider<MinimalExternalModuleDependency> getJs() { return create("client.js"); }

    }

    public static class ServerLibraryAccessors extends SubDependencyFactory {

        public ServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for cio (io.ktor:ktor-server-cio)
             * This dependency was declared in catalog ktor.toml
             */
            public Provider<MinimalExternalModuleDependency> getCio() { return create("server.cio"); }

            /**
             * Creates a dependency provider for cors (io.ktor:ktor-server-cors)
             * This dependency was declared in catalog ktor.toml
             */
            public Provider<MinimalExternalModuleDependency> getCors() { return create("server.cors"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: ktor (2.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog ktor.toml
             */
            public Provider<String> getKtor() { return getVersion("ktor"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
